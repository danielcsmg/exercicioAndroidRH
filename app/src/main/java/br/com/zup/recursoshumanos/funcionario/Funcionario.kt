package br.com.zup.recursoshumanos.funcionario

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Funcionario(
    private val nome: String,
    private val horasTrabalhadas: Int,
    private val valorHoras: Double
): Parcelable {
    fun getNome() = nome
    fun getHorasTrabalhadas() = horasTrabalhadas
    fun getValorHoras() = valorHoras
}