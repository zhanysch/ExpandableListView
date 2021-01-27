package ru.trinitydigital.explandablelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.trinitydigital.explandablelistview.databinding.ActivityMainBinding
import ru.trinitydigital.utils.viewBinding

class MainActivity : AppCompatActivity() {

    private val vm by viewModel<MainViewModel>()
    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val adapter by lazy { ExpandableAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupExpListView()
        setupViewModel()
    }

    private fun setupExpListView() {
        binding.listView.setAdapter(adapter)
    }

    private fun setupViewModel() {
        vm.data.observe(this, {
            adapter.update(it)
        })
    }
}