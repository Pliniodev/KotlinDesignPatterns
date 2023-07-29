package designPatterns.behavior.memento.example1

import designPatterns.behavior.memento.example1.model.EditorState
import divider

// Classe Editor
class Editor(var content: String = "") {

    // Salva o estado atual do Editor em um MementoState
    fun save(): EditorState {
        return EditorState(content)
    }

    // Restaura o estado do Editor a partir de um MementoState
    fun restore(state: EditorState) {
        content = state.content
    }

    // Mostra o conteúdo atual do Editor
    fun printContent() {
        divider()
        println("Conteúdo do Editor: $content")
    }
}