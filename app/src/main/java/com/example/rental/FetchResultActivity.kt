package com.example.rental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rental.adapters.ResultAdapter
import com.example.rental.util.Result
import kotlinx.android.synthetic.main.activity_fetch_result.*
import org.jetbrains.annotations.TestOnly

class FetchResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch_result)

        // TODO take the data from the internet instead of the hard coded.
        var abc = arrayListOf<Result>()
        abc.add(Result("Mumbai","North"))
        abc.add(Result("Delhi","South"))
        abc.add(Result("Mumbai","North"))

        result_list_view.adapter = ResultAdapter(FetchResultActivity@this, R.layout.result_list, abc)
    }
}
