package designPatterns.behavior.chainOfResponsability.example1

/**
 * Claro! O padrão de design Chain of Responsibility é usado para construir uma cadeia de objetos
 * receptores que tratam uma solicitação de forma sequencial. Cada objeto receptor na cadeia decide
 * se pode tratar a solicitação ou passá-la para o próximo objeto na cadeia. Vamos criar um exemplo
 * simples em Kotlin para entender esse padrão de design.
 *
 * Imagine que estamos desenvolvendo um sistema de aprovação de despesas. Temos três níveis de aprovação:
 * nível baixo, nível médio e nível alto. Cada nível tem um limite máximo de despesas que pode ser aprovado.
 * Se o nível não puder aprovar a despesa, ela passará para o próximo nível para uma nova tentativa de aprovação.
 */

// Interface representing a handler in the chain
interface ApprovalLevel {
    fun approve(score: Int): String
}

// Concrete class representing "Grade C" approval level
class GradeC(private val nextLevel: ApprovalLevel) : ApprovalLevel {
    override fun approve(score: Int): String {
        return if (score in 70..79) {
            "Score $score approved with 'Grade C'."
        } else {
            nextLevel.approve(score)
        }
    }
}

// Concrete class representing "Grade B" approval level
class GradeB(private val nextLevel: ApprovalLevel) : ApprovalLevel {
    override fun approve(score: Int): String {
        return if (score in 80..89) {
            "Score $score approved with 'Grade B'."
        } else {
            nextLevel.approve(score)
        }
    }
}

// Concrete class representing "Grade A" approval level
class GradeA : ApprovalLevel {
    override fun approve(score: Int): String {
        return if (score in 90..100) {
            "Score $score approved with 'Grade A'."
        } else {
            "Score $score not approved."
        }
    }
}

//fun main() {
//    val gradeA = GradeA()
//    val gradeB = GradeB(gradeA)
//    val gradeC = GradeC(gradeB)
//
//    val scores = listOf(45, 55, 65, 75, 85, 95, 105)
//
//    for (score in scores) {
//        println(gradeC.approve(score))
//    }
//}
//----------------------------------------------------------------------------------//

// Interface que representa um manipulador da cadeia
interface NivelAprovacao {
    fun aprovar(nota: Int): String
}

// Classe concreta que representa o nível de aprovação "Nota C"
class NotaC : NivelAprovacao {
    override fun aprovar(nota: Int): String {
        return if (nota >= 70 && nota <= 79) {
            "Nota $nota aprovada com 'Nota C'."
        } else {
            "Nota $nota não aprovada."
        }
    }
}

// Classe concreta que representa o nível de aprovação "Nota B"
class NotaB(private val proximoNivel: NivelAprovacao) : NivelAprovacao {
    override fun aprovar(nota: Int): String {
        return if (nota >= 80 && nota <= 89) {
            "Nota $nota aprovada com 'Nota B'."
        } else {
            proximoNivel.aprovar(nota)
        }
    }
}

// Classe concreta que representa o nível de aprovação "Nota A"
class NotaA(private val proximoNivel: NivelAprovacao) : NivelAprovacao {
    override fun aprovar(nota: Int): String {
        return if (nota >= 90 && nota <= 100) {
            "Nota $nota aprovada com 'Nota A'."
        } else {
            proximoNivel.aprovar(nota)
        }
    }
}

// Classe concreta que representa o fim da cadeia
class SemAprovacao : NivelAprovacao {
    override fun aprovar(nota: Int): String {
        return "Out of range"
    }
}

fun main() {
    val notaC = NotaC()
    val notaB = NotaB(notaC)
    val notaA = NotaA(notaB)

    val notas = listOf(45, 55, 65, 75, 85, 95, 105)

    for (nota in notas) {
        println(notaA.aprovar(nota))
    }
}


/**
 * Neste exemplo, as notas das provas são passadas pela cadeia de responsabilidade na ordem inversa, ou seja,
 * do nível "Nota C" para o nível "Nota B" e, por fim, para o nível "Nota A". Cada nível tenta aprovar a nota,
 * e caso a nota não seja aprovada em um determinado nível, a aprovação é passada para o próximo nível, até
 * que a nota seja aprovada ou seja menor que 70 e não seja aprovada. Isso ilustra o funcionamento do padrão
 * de design Chain of Responsibility com os níveis de aprovação "Nota A", "Nota B" e "Nota C", invertendo a
 * ordem da cadeia.
 */