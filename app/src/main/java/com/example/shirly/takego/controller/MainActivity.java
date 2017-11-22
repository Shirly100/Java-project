package com.example.shirly.takego.controller;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shirly.takego.R;

public class MainActivity extends Activity implements View.OnClickListener
{

    private Button addClientButton;
    private Button addCarModelButton;
    private Button addCarButton;
    private Button showBranchesListButton;
    private Button showCarListButton;
    private Button showModelListButton;
    private Button showClientListButton;
    private Button showOrderListButton;



    private void findViews()
    {
        addClientButton = (Button)findViewById( R.id.addClientButton );
        addCarModelButton = (Button)findViewById( R.id. addCarModelButton );
        addCarButton = (Button)findViewById( R.id.addCarButton );
        showBranchesListButton = (Button)findViewById( R.id.showBranchesListButton );
        showCarListButton = (Button)findViewById( R.id.showCarListButton );
        showModelListButton = (Button)findViewById( R.id.showModelListButton );
        showClientListButton = (Button)findViewById( R.id.showClientListButton);
        showOrderListButton = (Button)findViewById( R.id.showOrderListButton );
        addClientButton.setOnClickListener( this );
        addCarModelButton.setOnClickListener( this );
        addCarButton.setOnClickListener( this );
        showBranchesListButton.setOnClickListener( this );
        showCarListButton.setOnClickListener( this );
        showModelListButton.setOnClickListener( this );
        showClientListButton.setOnClickListener( this );
        showOrderListButton.setOnClickListener( this );

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public void onClick(View v) {
        if ( v == addClientButton ) {
            addClient();// Handle clicks for addStudentButton
            } /*else if ( v == addCarModelButton ) {
            addCarrModel();// Handle clicks for addLecturerButton
            }
              else if ( v == addCarButton  ) {
                addCar();// Handle clicks for addCourseButton
            } else if ( v == showBranchesListButton ) {
            showBranchesList();// Handle clicks for addStudentCourseButton
            } else if ( v == showCarListButton ) {
            showCarList();// Handle clicks for showStudentListButton
            } else if ( v == showModelListButton ) {
            showModelList();// Handle clicks for showCourseListButton
            }
        else if ( v == showClientListButton ) {
            showClientList();// Handle clicks for showCourseListButton
        }
        else if ( v == showOrderListButton ) {
            showOrderLis();// Handle clicks for showCourseListButton
        }*/
         }


    private  void  addClient()
    {
        Intent intent=new Intent(this,AddClientActivity.class);
        startActivity(intent);
    }

   /* private  void  addCar()
    {
        Intent intent=new Intent(this,AddCarActivity.class);
        startActivity(intent);
    }
    private  void  addCarrModel()
    {
        Intent intent=new Intent(this,AddCarModelActivity.class);
        startActivity(intent);
    }
    private  void  showBranchesList()
    {
        Intent intent=new Intent(this,showBranchesListActivity.class);
        startActivity(intent);
    }
    private  void  showCarList()
    {
        Intent intent=new Intent(this,showCarListActivity.class);
        startActivity(intent);
    }
    private  void  showClientList()
    {
        Intent intent=new Intent(this, showClientListActivity.class);
        startActivity(intent);
    }
    private  void  showModelList()
    {
        Intent intent=new Intent(this, showModelListActivity.class);
        startActivity(intent);
    }
    private  void   showOrderLis()
    {
        Intent intent=new Intent(this, showModelListActivity.class);
        startActivity(intent);
    }*/

}





