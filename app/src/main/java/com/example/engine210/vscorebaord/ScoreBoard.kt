package com.example.engine210.vscorebaord
class ScoreBoard (){
    lateinit var record: Scores
    constructor(
            left_team_match: Int = 0,
            left_team_score: Int = 0,
            right_team_match: Int = 0,
            right_team_score: Int = 0) : this() {
        this.record = Scores(left_team_match, left_team_score, right_team_match, right_team_score)
    }

    fun left_team_plus(){
        if (record.left_score < 24) {
            record.left_score++
        } else {
            record.left_score = 0
            record.left_match++
        }
    }
    fun left_team_minus(){
        if (record.left_score > 0) {
            record.left_score--
        } else if (record.left_score == 0 && record.left_match > 0) {
            record.left_match--
            record.left_score = 24
        }
    }

    fun left_team_match_plus(){
        record.left_match++
    }
    fun left_team_match_minus(){
        if (record.left_match > 0) {
            record.left_match--
        }
    }

    fun right_team_plus(){
        if (record.right_score < 24) {
            record.right_score++
        } else {
            record.right_score = 0
            record.right_match++
        }
    }
    fun right_team_minus(){
        if (record.right_score > 0) {
            record.right_score--
        } else if (record.right_score == 0 && record.right_match > 0) {
            record.right_match--
            record.right_score = 24
        }
    }

    fun right_team_match_plus(){
        record.right_match++
    }
    fun right_team_match_minus(){
        if (record.right_match > 0) {
            record.right_match--
        }
    }

    fun reset(){
        record.left_score = 0
        record.right_score = 0
        record.left_match = 0
        record.right_match = 0
    }
    
    fun switch(){
        record.left_score = record.right_score.also { record.right_score = record.left_score }
        record.left_match = record.right_match.also { record.right_match = record.left_match }
        record.left_background = record.right_background.also { record.right_background = record.left_background }
    }
    
}