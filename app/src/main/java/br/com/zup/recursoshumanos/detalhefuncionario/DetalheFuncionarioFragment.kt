package br.com.zup.recursoshumanos.detalhefuncionario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.recursoshumanos.R
import br.com.zup.recursoshumanos.databinding.FragmentDetalheFuncionarioBinding
import br.com.zup.recursoshumanos.funcionario.Funcionario

class DetalheFuncionarioFragment : Fragment() {
    private lateinit var binding: FragmentDetalheFuncionarioBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalheFuncionarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mostrarFuncionario()
    }

    fun mostrarFuncionario(){
        val funcionario = arguments?.getParcelable("FUNCIONARIO") as Funcionario?

        funcionario?.let{
            val totalAReceber = funcionario.getValorHoras() * funcionario.getHorasTrabalhadas()
            binding.etNomeFuncionario.text = funcionario.getNome()
            binding.etHorasTrabalhadas.text = getString(R.string.horas_de_trabalho, funcionario.getHorasTrabalhadas().toString())
            binding.etValorDasHoras.text = getString(R.string.valor_das_horas, "%.2f".format(funcionario.getValorHoras()))
            binding.tvTotalAReceber.text = getString(R.string.salario_a_receber, "%.2f".format(totalAReceber))
        }
    }


}