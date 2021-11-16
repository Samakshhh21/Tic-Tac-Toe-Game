package com.sampam.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    lateinit var board: Array<Array<Button>>
    var player = true
    var turn_count = 0
    var board_status = Array(3) { IntArray(3) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        board = arrayOf(
            arrayOf(button1, button2, button3),
            arrayOf(button4, button5, button6),
            arrayOf(button7, button8, button9)
        )
        for (i in board) {
            for (button in i) {
                button.setOnClickListener(this)
            }
        }
        initboardstatus()
        button10.setOnClickListener {
            player = true
            turn_count = 0
            initboardstatus()
        }
    }


    private fun initboardstatus() {
        textView.text = "PLAYER X TURN"
        for (i in 0..2) {
            for (j in 0..2) {
                board_status[i][j] = -1

            }
        }
        for (i in board) {
            for (button in i) {
                button.text = ""
                button.isEnabled = true
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button1 -> {
                updatevalue(row = 0, col = 0, player)
            }
            R.id.button2 -> {
                updatevalue(row = 0, col = 1, player)
            }
            R.id.button3 -> {
                updatevalue(row = 0, col = 2, player)
            }
            R.id.button4 -> {
                updatevalue(row = 1, col = 0, player)
            }
            R.id.button5 -> {
                updatevalue(row = 1, col = 1, player)
            }
            R.id.button6 -> {
                updatevalue(row = 1, col = 2, player)
            }
            R.id.button7 -> {
                updatevalue(row = 2, col = 0, player)
            }
            R.id.button8 -> {
                updatevalue(row = 2, col = 1, player)
            }
            R.id.button9 -> {
                updatevalue(row = 2, col = 2, player)
            }
        }
        player = !player
        turn_count++


        if (player) {
            textView.text = "PLAYER X TURN"
        } else {
            textView.text = "PLAYER O TURN"
        }
        if (turn_count == 9) {
            textView.text = "Game is DRAW"
        }
        checkwinner()
    }

    private fun checkwinner() {
        for (i in 0..2) {
            if (board_status[i][0] == board_status[i][1] && board_status[i][0] == board_status[i][2]) {
                if (board_status[i][0] == 1) {
                    textView.text = "PLAYER X IS WINNER"
                    if (textView.text.contains("WINNER")) {
                        disablebtn()
                    }
                    break
                } else if (board_status[i][0] == 0) {
                    textView.text = "PLAYER O IS WINNER"
                    if (textView.text.contains("WINNER")) {
                        disablebtn()
                    }
                    break
                }
            }
        }
        for (i in 0..2) {
            if (board_status[0][i] == board_status[1][i] && board_status[0][i] == board_status[2][i]) {
                if (board_status[0][i] == 1) {
                    textView.text = "PLAYER X IS WINNER"
                    if (textView.text.contains("WINNER")) {
                        disablebtn()
                    }
                    break
                } else if (board_status[0][i] == 0) {
                    textView.text = "PLAYER O IS WINNER"
                    if (textView.text.contains("WINNER")) {
                        disablebtn()
                    }
                    break
                }
            }
        }
        if (board_status[0][0] == board_status[1][1] && board_status[0][0] == board_status[2][2]) {
            if (board_status[0][0] == 1) {
                textView.text = "PLAYER X IS WINNER"
                if (textView.text.contains("WINNER")) {
                    disablebtn()
                }
            } else if (board_status[0][0] == 0) {
                textView.text = "PLAYER O IS WINNER"
                if (textView.text.contains("WINNER")) {
                    disablebtn()
                }
            }
        }
        if (board_status[0][2] == board_status[1][1] && board_status[0][2] == board_status[2][0]) {
            if (board_status[0][2] == 1) {
                textView.text = "PLAYER X IS WINNER"
                if (textView.text.contains("WINNER")) {
                    disablebtn()
                }
            } else if (board_status[0][2] == 0) {
                textView.text = "PLAYER O IS WINNER"
                if (textView.text.contains("WINNER")) {
                    disablebtn()
                }
            }
        }
    }

    private fun disablebtn() {
        for (i in board) {
            for (button in i) {
                button.isEnabled = false
            }
        }
    }


    private fun updatevalue(row: Int, col: Int, player: Boolean) {
        val text: String = if (player) "X" else "O"
        val value: Int = if (player) 1 else 0
        board[row][col].apply {
            setText(text)
            isEnabled = false
        }
        board_status[row][col] = value
    }
}