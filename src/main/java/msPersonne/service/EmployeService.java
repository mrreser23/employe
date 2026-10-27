package msPersonne.service;

import msPersonne.entite.Employe;
import msPersonne.reponse.EmployeReponse;
import msPersonne.repository.EmployeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmployeService {

    private final EmployeRepo employeRepo;
    private final ModelMapper mapper;

    public EmployeService(EmployeRepo employeRepo, ModelMapper mapper) {
        this.employeRepo = employeRepo;
        this.mapper = mapper;
    }

    public EmployeReponse getEmployeById(int id) {
        Employe employe = employeRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Employe introuvable"));

        return mapper.map(employe, EmployeReponse.class);
    }
}