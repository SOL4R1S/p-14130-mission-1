package com

import com.Wisesaying.Controller

class App {
    fun run() {
        val wsController = Controller()

        println("== 명언 앱 ==")

        while (true) {
            print("명령) ")

            val input = readlnOrNull()!!.trim()

            val rq = Rq(input)

            when (rq.action) {
                "종료" -> {
                    wsController.actionExit(rq)
                    break
                }

                "등록" -> wsController.actionWrite(rq)
                "목록" -> wsController.actionList(rq)
                "삭제" -> wsController.actionDelete(rq)
                "수정" -> wsController.actionModify(rq)
            }
        }
    }
}