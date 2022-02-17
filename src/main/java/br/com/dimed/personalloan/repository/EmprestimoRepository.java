package br.com.dimed.personalloan.repository;

import br.com.dimed.personalloan.constants.Constantes;
import br.com.dimed.personalloan.model.Emprestimo;
import br.com.dimed.personalloan.model.EstadoEnum;
import br.com.dimed.personalloan.model.TipoEmprestimoEnum;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
public class EmprestimoRepository {

    public List<Emprestimo> simulationQueryLoans(Integer renda, Integer idade, EstadoEnum local) {

        List<Emprestimo> list = new ArrayList<>();

        list.add(Emprestimo.builder()
                .tipo(TipoEmprestimoEnum.PESSOAL)
                .imposto(Constantes.EMPRESTIMO_PESSOAL)
                .build());

        if (less30years(idade) && incomeHigh(renda))
            list.add(Emprestimo.builder().
                    tipo(TipoEmprestimoEnum.GARANTIDO)
                    .imposto(Constantes.EMPRESTIMO_GARANTIDO)
                    .build());

        if (incomeNormal(renda) && liveInSP(local))
            list.add(Emprestimo.builder()
                    .tipo(TipoEmprestimoEnum.GARANTIDO)
                    .imposto(Constantes.EMPRESTIMO_GARANTIDO)
                    .build());

        if (incomeLow(renda) && less30years(idade) && liveInSP(local))
            list.add(Emprestimo.builder()
                    .tipo(TipoEmprestimoEnum.GARANTIDO)
                    .imposto(Constantes.EMPRESTIMO_GARANTIDO)
                    .build());

        if (incomeHigh(renda))
            list.add(Emprestimo.builder()
                    .tipo(TipoEmprestimoEnum.CONSIGNADO)
                    .imposto(Constantes.EMPRESTIMO_CONSIGNADO)
                    .build());

        return list;

    }

    private boolean incomeHigh(Integer renda) {
        return renda >= Constantes.ALTA_RENDA;
    }

    private boolean incomeLow(Integer renda) {
        return renda <= Constantes.BAIXA_RENDA;
    }

    private boolean incomeNormal(Integer renda) {
        return renda > Constantes.BAIXA_RENDA && renda < Constantes.ALTA_RENDA;
    }

    private boolean liveInSP(EstadoEnum local) {
        return local.equals(EstadoEnum.SP);
    }

    private boolean less30years(Integer idade) {
        return idade < Constantes.IDADE_NEGOCIO;
    }

}
