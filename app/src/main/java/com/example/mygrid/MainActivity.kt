package com.example.mygrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mygrid.ui.theme.MyGridTheme
import com.example.mygrid.Models.Topic
import com.example.mygrid.data.DataSource
import com.example.mygrid.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyGridTheme {
            topiCard()
            }
        }
    }
}


@Composable
fun topiCard(){
    LazyVerticalGrid(columns = GridCells.Fixed(2) , Modifier.statusBarsPadding()) {
            items(DataSource.topics){ topici ->
                myCard(topic = topici)

            }
    }
}

@Composable
fun myCard(topic: Topic){
    Card(Modifier.padding(8.dp)) {
        Row {


        Image(painter = painterResource(id =topic.imageres ), contentDescription = stringResource(id = topic.stringvalue) ,
            Modifier
                .height(68.dp)
                .width(68.dp))
            Column {


            Text(text = stringResource(id = topic.stringvalue),Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp), style = Typography.bodyMedium)
                Text(text= topic.availvalue.toString(),Modifier.padding(start = 16.dp), style = Typography.labelMedium)
        }}}
}


@Preview
@Composable
fun appPrev(){
    myCard(Topic(R.string.app_name,58,R.drawable.tech))
}