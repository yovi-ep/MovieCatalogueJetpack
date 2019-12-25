package yovi.putra.moviecatalogue.core.base

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import retrofit2.HttpException
import yovi.putra.moviecatalogue.R
import yovi.putra.moviecatalogue.core.utils.ui.LoadingController

/**
 * Created by yovi.putra
 * on 09/Mar/2019 10:56
 * Company SIEMO - PT. Multipolar Technology, Tbk
 */
abstract class BaseActivity : AppCompatActivity(), IBaseView {

    private val loading: LoadingController by lazy {
        LoadingController(this)
    }

    override val contextView: Context
        get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setupLayoutId())
        setupData()
        setupUI()
    }

    abstract fun setupLayoutId() : Int

    abstract fun setupData()

    abstract fun setupUI()

    override fun onShowLoader() {
        loading.show()
    }

    override fun onHideLoader() {
        loading.hide()
    }
}