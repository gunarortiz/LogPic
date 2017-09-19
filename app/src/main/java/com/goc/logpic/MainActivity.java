package com.goc.logpic;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import com.goc.logpic.adaptadores.CartaCursoAdapter;
import com.goc.logpic.db.DataBaseManagerCurso;
import com.goc.logpic.model.Curso;

public class MainActivity extends AppCompatActivity {

    private Button btnInsertar,btnActualizar, btnBorrar,btnConsultar;

    private DataBaseManagerCurso managerCurso;
    private RecyclerView recycler;
    private CartaCursoAdapter adapter;
    private RecyclerView.LayoutManager lManager;
    private List<Curso> listaItemsCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar a=(Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(a);

        managerCurso= new DataBaseManagerCurso(this);
        //adViews();


        listaItemsCursos = managerCurso.getCursosList();

        recycler = (RecyclerView) findViewById(R.id.listas);
        recycler.setHasFixedSize(true);
        //recycler.setLayoutManager(new GridLayoutManager(this,3));


        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);
    recycler.setSelected(true);
        adapter = new CartaCursoAdapter(listaItemsCursos, this);
        adapter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int itemPosition = recycler.indexOfChild(v);
                        //    Toast.makeText(MainActivity.this,"Selected item position is---"+ itemPosition,Toast.LENGTH_SHORT).show();
                        TextView textView = (TextView)v.findViewById(R.id.textview_curso_id);
                        Toast.makeText(MainActivity.this,"Selected val of clicked position is---"+ textView.getText().toString(),Toast.LENGTH_SHORT).show();
                        Intent a=new Intent(MainActivity.this, ShowActivity.class);
                        a.putExtra("ids",textView.getText().toString());
                        startActivity(a);


                    }
                }




                //new View.OnClickListener() {
           // @Override
            //public void onClick(View v) {
                //Log.i("DemoRecView", "Pulsado el elemento " + recycler.getChildPosition(v));

            //    Toast.makeText(MainActivity.this, recycler.getChildAdapterPosition(v)+"", Toast.LENGTH_SHORT).show();

            //}
       // }
        );

        recycler.setAdapter(adapter);

        recycler.setItemAnimator(new DefaultItemAnimator());
    }
/*
    private void adViews() {
        btnInsertar=(Button) findViewById(R.id.btnInsertar);
        btnInsertar.setOnClickListener(this);

        btnBorrar=(Button) findViewById(R.id.btnBorrar);
        btnBorrar.setOnClickListener(this);

        btnActualizar=(Button) findViewById(R.id.btnActalizar);
        btnActualizar.setOnClickListener(this);

        btnConsultar=(Button) findViewById(R.id.btnConsulta);
        btnConsultar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnInsertar:

                for (int i=0; i<10; i++){
                    managerCurso.insertar_4parametros(null, "curso"+i, "fecha "+i,"img",""+i*2 );
                }

                break;
            case R.id.btnBorrar:
                managerCurso.eliminarTodo();
                break;

            case R.id.btnActalizar:
                for(int i=0; i< listaItemsCursos.size(); i++) {
                    managerCurso.actualizar_4parametros(listaItemsCursos.get(i).getId(), "curso:" + i, "fechaI" + i,"Img", "" + i * 5);
                }
                break;

            case R.id.btnConsulta:
                recargarRecicler();
                break;
        }
    }
*/
    private void recargarRecicler() {
        //cargar datos
        listaItemsCursos = managerCurso.getCursosList();
        // Crear un nuevo adaptador
        adapter = new CartaCursoAdapter(listaItemsCursos, this);
        recycler.setAdapter(adapter);
        recycler.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void onDestroy() {
        managerCurso.cerrar();
        super.onDestroy();
    }


}