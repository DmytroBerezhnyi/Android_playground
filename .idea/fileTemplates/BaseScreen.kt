package ${PACKAGE_NAME}

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.androidplayground.R
import com.example.androidplayground.architecture.base.BaseFragment
import com.example.androidplayground.architecture.base.BaseViewModel
import javax.inject.Inject
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.androidplayground.databinding.${NAME}FragmentBinding as Binding
import ${PACKAGE_NAME}.${NAME}VM as VM

@AndroidEntryPoint
class ${NAME}Fragment: BaseFragment<Binding, VM>() {

    override val layoutId = R.layout.${fragment_name_id}

    override val vm: VM by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
    }
}

@HiltViewModel
class ${NAME}VM @Inject constructor(): BaseViewModel()