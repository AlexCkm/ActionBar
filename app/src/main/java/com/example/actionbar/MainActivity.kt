package com.example.actionbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.app.NavUtils
import com.example.actionbar.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    companion object{
        val ID_Ajustes = Menu.FIRST
        val ID_MasAjustes = Menu.FIRST + 1
        val ID_Snackbar = Menu.FIRST +2
    }
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)




        val actionBar = supportActionBar

        actionBar!!.title = " Action Bar"
        actionBar!!.subtitle = "Design a custom Action Bar"
        actionBar.setIcon(R.drawable.ic_dinero)

        actionBar.setDisplayUseLogoEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true) //para volver a casa

        registerForContextMenu(binding.tvHelloWorld)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(Menu.NONE, ID_Ajustes, Menu.NONE,"Ajustes")
        menu?.add(Menu.NONE, ID_MasAjustes, Menu.NONE,"Mas ajustes")
        menu?.add(Menu.NONE, ID_Snackbar, Menu.NONE,"Informacíon")
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itOption1 -> {
                Snackbar.make(binding.root, "Necesito una cerveza", Snackbar.LENGTH_SHORT).show()
                return true
            }
            R.id.itOption2 -> {
                Snackbar.make(binding.root, "Necesito una cerveza", Snackbar.LENGTH_SHORT).show()
                return true
            }
            R.id.itOption3 -> {
                Snackbar.make(binding.root, "Necesito una cerveza", Snackbar.LENGTH_SHORT).show()
                return true
            }

        }
        return false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        super.onOptionsItemSelected(item)
        if (id==R.id.search){
            NavUtils.navigateUpTo(this, Intent(this, ItemListActivity::class.java))
        }
        when (item.itemId) {
            R.id.search ->{
                Snackbar.make(binding.root, "Search Clicked", Snackbar.LENGTH_SHORT).show()
                return true
            }

            R.id.option2 ->{
                Snackbar.make(binding.root, "Refresh Clicked", Snackbar.LENGTH_SHORT).show()
                return true
            }

            R.id.great -> {
                Snackbar.make(binding.root, "Copy Clicked", Snackbar.LENGTH_SHORT).show()
                return true
            }

            R.id.itOption1 -> {
                Snackbar.make(binding.root, "Necesito una cerveza", Snackbar.LENGTH_SHORT).show()
                return true
            }

            ID_Ajustes -> {
                Snackbar.make(binding.root, "Mira ajustes", Snackbar.LENGTH_SHORT).show()
                return true
            }
            ID_MasAjustes -> {
                val int = Intent(this, ResultActivity::class.java)
                startActivity(int)
                return true
            }
            ID_Snackbar -> {
                Snackbar.make(binding.root, "Cerveza", Snackbar.LENGTH_SHORT).show()
                return true
            }

        }
        return false

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        view: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, view, menuInfo)
        if (view?.id == R.id.tvHelloWorld){
            menuInflater.inflate(R.menu.contextual_menu, menu)
        }
    }
}