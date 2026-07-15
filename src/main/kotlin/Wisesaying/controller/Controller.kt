package com.Wisesaying.controller

import com.Wisesaying.rq.Rq
import com.Wisesaying.service.Service
import kotlin.collections.reversed

class Controller {
    private var service = Service()

    fun actionWrite(rq: Rq) {
        print("명언 : ")
        val content = readlnOrNull() ?: ""

        print("작가 : ")
        val author = readlnOrNull() ?: ""

        val wiseSaying = service.write(content, author)

        println("${wiseSaying.id}번 명언이 등록되었습니다.")
    }

    fun actionList(rq: Rq) {
        if (service.isEmpty()) {
            println("등록된 명언이 없습니다.")
            return
        }

        println("번호 / 작가 / 명언")
        println("----------------------")

        service.findAll().reversed().forEach {
            println("${it.id} / ${it.author} / ${it.content}")
        }
    }

    fun actionDelete(rq: Rq) {
        val id = rq.getParamValueAsInt("id")
        if (id == null) {
            println("id를 정확히 입력해주세요.")
            return
        }

        val wiseSaying = service.findById(id)

        if (wiseSaying == null) {
            println("${id}번 명언은 존재하지 않습니다.")
            return
        }
        service.delete(wiseSaying)
        println("${id}번 명언을 삭제하였습니다.")
    }

    fun actionModify(rq: Rq) {
        val id = rq.getParamValueAsInt("id")
        if (id == null) {
            println("id를 정확히 입력해주세요.")
            return
        }
        val wiseSaying = service.findById(id)

        if (wiseSaying == null) {
            println("${id}번 명언은 존재하지 않습니다.")
            return
        }

        println("명언(기존) : ${wiseSaying.content}")
        print("명언 : ")
        val content = readlnOrNull()!!.trim()

        println("작가(기존) : ${wiseSaying.author}")
        print("작가 : ")
        val author = readlnOrNull()!!.trim()

        service.modify(wiseSaying, content, author)

        println("${id}번 명언을 수정하였습니다.")
    }

    fun actionExit(rq: Rq) {
        println("프로그램을 종료합니다.")
    }




}