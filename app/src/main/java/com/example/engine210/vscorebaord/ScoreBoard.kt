package com.example.engine210.vscorebaord

import java.util.*

/// FIXME(Unsure usage of stack. Pass by reference? value?)
class ScoreBoard {
    var record = Scores(0, 0, 0, 0)
    private var history: Stack<Scores> = Stack()

    fun leftTeamPlus() {
        history.push(Scores(record.left_match, record.left_score, record.right_match, record.right_score, record.left_background, record.right_background))
        if (record.left_score < 24) {
            record.left_score++
        } else {
            record.left_score = 0
            record.left_match++
        }
    }

    fun leftTeamMinus() {
        history.push(Scores(record.left_match, record.left_score, record.right_match, record.right_score, record.left_background, record.right_background))
        if (record.left_score > 0) {
            record.left_score--
        } else if (record.left_score == 0 && record.left_match > 0) {
            record.left_match--
            record.left_score = 24
        }
    }

    fun leftTeamMatchPlus() {
        history.push(Scores(record.left_match, record.left_score, record.right_match, record.right_score, record.left_background, record.right_background))
        record.left_match++
    }

    fun leftTeamMatchMinus() {
        history.push(Scores(record.left_match, record.left_score, record.right_match, record.right_score, record.left_background, record.right_background))
        if (record.left_match > 0) {
            record.left_match--
        }
    }

    fun rightTeamPlus() {
        history.push(Scores(record.left_match, record.left_score, record.right_match, record.right_score, record.left_background, record.right_background))
        if (record.right_score < 24) {
            record.right_score++
        } else {
            record.right_score = 0
            record.right_match++
        }
    }

    fun rightTeamMinus() {
        history.push(Scores(record.left_match, record.left_score, record.right_match, record.right_score, record.left_background, record.right_background))
        if (record.right_score > 0) {
            record.right_score--
        } else if (record.right_score == 0 && record.right_match > 0) {
            record.right_match--
            record.right_score = 24
        }
    }

    fun rightTeamMatchPlus() {
        history.push(Scores(record.left_match, record.left_score, record.right_match, record.right_score, record.left_background, record.right_background))
        record.right_match++
    }

    fun rightTeamMatchMinus() {
        history.push(Scores(record.left_match, record.left_score, record.right_match, record.right_score, record.left_background, record.right_background))
        if (record.right_match > 0) {
            record.right_match--
        }
    }

    fun switch() {
        history.push(Scores(record.left_match, record.left_score, record.right_match, record.right_score, record.left_background, record.right_background))
        record.left_score = record.right_score.also { record.right_score = record.left_score }
        record.left_match = record.right_match.also { record.right_match = record.left_match }
        record.left_background = record.right_background.also { record.right_background = record.left_background }
    }

    fun reset() {
        history.push(Scores(record.left_match, record.left_score, record.right_match, record.right_score, record.left_background, record.right_background))
        record.left_score = 0
        record.right_score = 0
        record.left_match = 0
        record.right_match = 0
    }

    fun undo() {

        if (!history.empty()) {
            record = history.pop()
        }
    }
}