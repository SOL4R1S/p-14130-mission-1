package com.Wisesaying.service

import com.Wisesaying.entity.WiseSaying

class Service {
    private var lastId=0
    private val wiseSayings=mutableListOf<WiseSaying>()

    fun write(content: String, author: String): WiseSaying {
        val id = ++lastId
        return WiseSaying(id, content, author).apply { wiseSayings.add(this) }
    }

    fun findById(id: Int): WiseSaying? {
        return wiseSayings.find { it.id == id }
    }
    fun delete(wiseSaying: WiseSaying) {
        wiseSayings.remove(wiseSaying)
    }

    fun isEmpty(): Boolean {
        return wiseSayings.isEmpty()
    }
    fun findAll(): List<WiseSaying> {
        return wiseSayings
    }

    fun modify(wiseSaying: WiseSaying, content: String, author: String) {
        val index = wiseSayings.indexOf(wiseSaying)
        if (index != -1) {
            wiseSayings[index] = wiseSaying.copy(content = content, author = author)
        }
    }
}