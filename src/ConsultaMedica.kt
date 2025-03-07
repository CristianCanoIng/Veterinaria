class ConsultaMedica : Mascota {
    var diagnostico: String = ""
    var costo: Double = 0.0
    var incluyeMedicacion: Boolean = false

    constructor() : super()

    constructor(mascota: Mascota, diagnostico: String, costo: Double, incluyeMedicacion: Boolean) : super(mascota.nombre, mascota.especie, mascota.edad, mascota.peso) {
        this.diagnostico = diagnostico
        this.costo = costo
        this.incluyeMedicacion = incluyeMedicacion
    }

    fun calcularCosto(): Double {
        return if (incluyeMedicacion) costo * 1.15 else costo
    }

    override fun toString(): String {
        return "Mascota: ${describirMascota()}, Diagnostico: $diagnostico, Costo: ${calcularCosto()}"
    }
}