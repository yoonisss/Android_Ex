package com.example.ch17_database_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.example.ch17_database_test.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    //이름 문자열을 담는 배열
    var datas: MutableList<String>? = null
    //나이 문자열을 담는 배열
    var datas2: MutableList<String>? = null
    //MyAdapter2 클래스 명으로 만들었음. 리사이클러뷰 사용하기 위해서 필요한 재료
    lateinit var adapter: MyAdapter2

    // savedInstanceState: Bundle-> 임시로 번들 객체에 담아두는 것.
    //onCreate, restoreInstanceState, 3개만 매개변수로 번들 객체를 이용함.
    //임시로 저장하면, 액티비티 화면에서 작업했던 에디트 텍스트 뷰라든지
    //화면 회전을 하면 사라지는데, 번들 객체에 자동으로 임시 저장 가능.
    //단점. 앱을 다시 실행하면, 사라짐. -> 내부 및 외부 저장소를 이용함.
    //현재, SQLite 데이터베이스를 이용.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //바인딩. 뷰 작업 편하게.
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //현재 메인 에서-> 입력 액티비티에서, 이름 나이 입력하고 그 값을 처리하는 부분이 여기.
        //입력 액티비티 finish()호출해서, 메인 액티비티로 넘어 왔고, 인텐트에 담은 객체 활용
        val requestLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult())
        {
            //이름을 처리하는 부분
            it.data!!.getStringExtra("result_name")?.let {
                //result_name의 키에 해당하는 값을 가져온 -> it
                datas?.add(it)
                //어댑터에 연결된 datas, datas2
                adapter.notifyDataSetChanged()
            }
            it.data!!.getStringExtra("result_age")?.let {
                datas?.add(it)
                adapter.notifyDataSetChanged()
            }
        }
        binding.mainFab2.setOnClickListener {
            //간단히 다른 액티비티 화면으로 이동할때
            //지금은 후처리가 다 들어가 있음.
            val intent = Intent(this, AddActivity2::class.java)
            requestLauncher.launch(intent)
        }

        //실제 이름, 나이를 담는 배열의 초기화는 여기서 함.
        datas= mutableListOf<String>()
        datas2= mutableListOf<String>()

        //add......................

        // 디비 select
        val db = DBHelper(this).readableDatabase
        val cursor = db.rawQuery("select * from USER", null)
        cursor.run {
            while(moveToNext()){
                //첫 컬럼 이름을 값을 읽어서 배열에 담기.
                datas?.add(cursor.getString(1))
                //두번째 컬럼 나이 값을 읽어서 배열에 담기
                datas2?.add(cursor.getString(2))
            }
        }
        db.close()

        //리사이클러 뷰에서,
        //메인에 리사이클러뷰 어댑터, 레이아웃 매니저를 연결하는 부분.
        val layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerView2.layoutManager=layoutManager
        adapter=MyAdapter2(datas,datas2)
        binding.mainRecyclerView2.adapter=adapter
        //목록의 요소를 꾸며주는 옵션부분.
        binding.mainRecyclerView2.addItemDecoration(
            DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId===R.id.menu_main_setting){
            val intent = Intent(this, SettingActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

}