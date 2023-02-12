package com.example.androidprhome.presentation.auths

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidprhome.App
import com.example.androidprhome.R
import com.example.androidprhome.databinding.FragmentLoginBinding
import com.example.androidprhome.utils.NavHelper.navigateWithDeletedBackStack
import javax.inject.Inject


class LoginFragment : Fragment(), LoginView {


    private var _viewBinding: FragmentLoginBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var loginPresenter: LoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentLoginBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity().applicationContext as App).provideAppComponent().inject(this)

        loginPresenter.setView(this)

        viewBinding.btnLogin.setOnClickListener {
            if (viewBinding.edName.text.toString().isEmpty() || viewBinding.edName.length() > 20) {
                viewBinding.edName.error = getString(R.string.inc_login)
            } else if (viewBinding.edPassword.text.toString()
                    .isEmpty() || viewBinding.edPassword.length() > 20
            ) {
                viewBinding.edPassword.error = getString(R.string.inc_password)
            } else {
                loginPresenter.loginUser(
                    viewBinding.edName.text.toString(),
                    viewBinding.edPassword.text.toString()
                )
            }
        }
    }

    override fun userLoggedIn(destination: Int, removeFragment: Int) {
        navigateWithDeletedBackStack(destination, removeFragment)
    }
}