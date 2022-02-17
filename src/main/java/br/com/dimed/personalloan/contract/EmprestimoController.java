package br.com.dimed.personalloan.contract;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    private EmprestimoFacade facade;

    public EmprestimoController() {
        facade = new EmprestimoFacade();
    }

    @GetMapping()
    public ResponseEntity<EmprestimoResponse> getTypesLoanAvailable(@Valid @RequestBody EmprestimoRequest obj) {
        return ResponseEntity.ok(facade.getTypesLoanAvailable(obj));
    }

}
