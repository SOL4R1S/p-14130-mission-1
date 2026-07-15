package com

var nextId = 1
val wiseSayings = mutableListOf<WiseSaying>()

data class WiseSaying(
    val id: Int,
    val content: String,
    val author: String
)

fun main() {
    println("== 명언 앱 ==")
    while (true) {
        print("명령) ")
        val input = readlnOrNull() ?: ""
        val parts = input.split("?")
        val command = parts[0]

        when (command) {
            "종료" -> break
            "등록" -> regist()
            "목록" -> list()
            "삭제" -> {
                val id = parts[1].split("=")[1].toInt()
            }

            else -> println("알 수 없는 명령입니다.")
        }
    }
}

fun regist() {
    print("명언 : ")
    val content = readlnOrNull() ?: ""

    print("작가 : ")
    val author = readlnOrNull() ?: ""

    val wiseSaying = WiseSaying(nextId, content, author)
    wiseSayings.add(wiseSaying)

    println("${nextId}번 명언이 등록되었습니다.")
    nextId++
}

fun list() {
    println("번호 / 작가 / 명언")
    println("----------------------")

    if (wiseSayings.isEmpty()) {
        println("등록된 명언이 없습니다.")
        return
    }

    for (wiseSaying in wiseSayings.reversed()) {
        println("${wiseSaying.id} / ${wiseSaying.author} / ${wiseSaying.content}")
    }
}

fun delete(id: Int) {

    val removed = wiseSayings.removeIf { it.id == id }
    if (removed) {
        print("${id}번 명언이 삭제되었습니다.")
    } else {
        print("${id}번 명언은 존재하지 않습니다.")
        return
    }
}