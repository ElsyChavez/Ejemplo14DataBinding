package com.aldana.ejemplo14

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.aldana.ejemplo14.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var scoreViewModel = ScoreViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            scoreViewModel.scoreTeamA.set(savedInstanceState.getString("keyA"))
            scoreViewModel.scoreTeamB.set(savedInstanceState.getString("keyB"))
        } else {
            scoreViewModel.scoreTeamA.set("0")
            scoreViewModel.scoreTeamB.set("0")
        }

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.score = scoreViewModel
    }


    // TODO: Accediendo y modificando datos almacenados en el ViewModel según el método utilizado

    fun addOneTeamA(v: View) {
        displayScore(
            tv_score_team_a,
            ++scoreViewModel.scoreTeamA
        )
    }

    fun addOneTeamB(v: View) {
        displayScore(
            tv_score_team_b,
            ++scoreViewModel.scoreTeamB
        )
    }

    fun addTwoTeamA(v: View) {
        scoreViewModel.scoreTeamA += 2
        displayScore(
            tv_score_team_a,
            scoreViewModel.scoreTeamA
        )
    }

    fun addTwoTeamB(v: View) {
        scoreViewModel.scoreTeamB += 2
        displayScore(
            tv_score_team_b,
            scoreViewModel.scoreTeamB
        )
    }

    fun addThreeTeamA(v: View) {
        scoreViewModel.scoreTeamA += 3
        displayScore(
            tv_score_team_a,
            scoreViewModel.scoreTeamA
        )
    }

    fun addThreeTeamB(v: View) {
        scoreViewModel.scoreTeamB += 3
        displayScore(
            tv_score_team_b,
            scoreViewModel.scoreTeamB
        )
    }

    fun resetScores(v: View) {
        scoreViewModel.scoreTeamA = 0
        scoreViewModel.scoreTeamB = 0

        displayScore(
            tv_score_team_a,
            scoreViewModel.scoreTeamA
        )

        displayScore(
            tv_score_team_b,
            scoreViewModel.scoreTeamB
        )
    } // TODO: Limpiando datos

    fun displayScore(v: TextView, score: Int) {
        v.text = score.toString()
    }

}
