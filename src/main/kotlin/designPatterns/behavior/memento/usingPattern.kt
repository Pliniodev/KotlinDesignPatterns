package designPatterns.behavior.memento

import designPatterns.behavior.memento.example1.Editor
import designPatterns.behavior.memento.example1.EditorHistory

fun main() {
    val editor = Editor()
    val history = EditorHistory()

    // Escrevendo conteúdo no Editor e salvando um estado (memento)
    editor.content = "\nPrimeira linha do texto."
    history.push(editor.save())
    editor.printContent()

    // Escrevendo mais conteúdo no Editor e salvando outro estado (memento)
    editor.content += "\nSegunda linha do texto."
    history.push(editor.save())
    editor.printContent()

    // Escrevendo ainda mais conteúdo no Editor (estado atual)
    editor.content += "\nTerceira linha do texto."
    editor.printContent()

    // Restaurando o Editor para o estado anterior usando o estado (memento) salvo
    val state = history.pop()
    if (state != null) {
        editor.restore(state)
    }
    editor.printContent()
}
