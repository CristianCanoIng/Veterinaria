import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val listaMascotas = mutableListOf<Mascota>()
    val listaConsultas = mutableListOf<ConsultaMedica>()

    while (true) {
        println("""
            
                         __,                      ,__
                      __/==+\  MENU DE OPCIONES  /+==\__
                        "  "`   ===============   '"  "
                        
        """.trimIndent())
        println("[1] Registrar nueva mascota")
        println("[2] Registrar consulta medica")
        println("[3] Mostrar historial de consultas")
        println("[4] Modificar datos de una mascota")
        println("[5] Calcular costo total de consultas de una mascota")
        println("[6] Listar todas las mascotas")
        println("[7] Salir")
        print("\nSeleccione una opcion: ")

        var opcion = readln().toInt()
        when (opcion) {
            1 -> {
                print("[]Ingrese nombre de la mascota: ")
                val nombre = scanner.next()
                print("[]Ingrese especie: ")
                val especie = scanner.next()
                print("[]Ingrese edad: ")
                val edad = scanner.nextInt()
                print("[]Ingrese peso: ")
                val peso = scanner.nextDouble()
                listaMascotas.add(Mascota(nombre, especie, edad, peso))
                println("+ Mascota registrada en el sistema")
            }
            2 -> {
                print("[]Ingrese el nombre de la mascota: ")
                val nombre = scanner.next()
                val mascota = listaMascotas.find { it.nombre == nombre }
                if (mascota != null) {
                    println("[]Datos de la mascota: ${mascota.describirMascota()}")
                    print("[]Ingrese diagnóstico: ")
                    val diagnostico = scanner.next()
                    print("[]Ingrese costo de la consulta: ")
                    val costo = scanner.nextDouble()
                    print("[]¿Incluye medicación? (true/false): ")
                    val incluyeMedicacion = scanner.nextBoolean()
                    listaConsultas.add(ConsultaMedica(mascota, diagnostico, costo, incluyeMedicacion))
                    println("[]Consulta registrada")
                } else {
                    println("[]Esta mascota no esta en el sistema")
                }
            }
            3 -> {
                println("\n[]Historial de las consultas:")
                listaConsultas.forEach { println(it) }
            }
            4 -> {
                print("[]Ingrese el nombre de la mascota a modificar: ")
                val nombre = scanner.next()
                val mascota = listaMascotas.find { it.nombre == nombre }
                if (mascota != null) {
                    println("[]Datos actuales de la mascota: ${mascota.describirMascota()}")
                    print("[]Ingrese nuevo peso: ")
                    val nuevoPeso = scanner.nextDouble()
                    mascota.actualizarPeso(nuevoPeso)
                    print("[]¿Desea aumentar la edad de la mascota? Ingrese true o false: ")
                    if (scanner.nextBoolean()) {
                        mascota.incrementarEdad()
                    }
                    println("Datos de la mascota nuevos: ${mascota.describirMascota()}")
                } else {
                    println("Esta mascota no esta en el sistema")
                }
            }
            5 -> {
                print("Ingrese el nombre de la mascota: ")
                val nombre = scanner.next()
                val totalCosto = listaConsultas.filter { it.nombre == nombre }.sumOf { it.calcularCosto() }
                println("Costo total de consultas para $nombre: $totalCosto")
            }
            6 -> {
                println("\nLista de todas las mascotas:")
                listaMascotas.forEach { println(it.describirMascota()) }
            }
            7 -> {
                println("Adios")
                break
            }
            else -> println("Opcion no disponible")
        }
    }
}
