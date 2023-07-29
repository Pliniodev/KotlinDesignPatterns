package designPatterns.behavior.memento.example1

import designPatterns.behavior.memento.example1.model.EditorState

// Classe que gerencia os mementos do Editor
class EditorHistory {
    private val states = mutableListOf<EditorState>()

    // Adiciona um EditorState à lista de estados
    fun push(state: EditorState) {
        states.add(state)
    }

    // Remove e retorna o último EditorState da lista de estados
    fun pop(): EditorState? {
        if (states.isNotEmpty()) {
            val lastIndex = states.size - 1
            val lastState = states[lastIndex]
            states.removeAt(lastIndex)
            return lastState
        }
        return null
    }
}