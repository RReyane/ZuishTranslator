package com.reyane.zuishtranslator

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputConnection
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.ViewSwitcher


class ZuishKeyboard @JvmOverloads constructor( context: Context,
                                               attrs: AttributeSet? = null,
                                               defStyleAttr: Int = 0 ) :
            LinearLayout(context, attrs, defStyleAttr), View.OnClickListener {

    // keyboard keys (buttons)
    private var mAButton: ImageButton? = null
    private var mBButton: ImageButton? = null
    private var mCButton: ImageButton? = null
    private var mDButton: ImageButton? = null
    private var mEButton: ImageButton? = null
    private var mFButton: ImageButton? = null
    private var mGButton: ImageButton? = null
    private var mHButton: ImageButton? = null
    private var mIButton: ImageButton? = null
    private var mJButton: ImageButton? = null
    private var mKQButton: ImageButton? = null
    private var mLButton: ImageButton? = null
    private var mMButton: ImageButton? = null
    private var mNButton: ImageButton? = null
    private var mOButton: ImageButton? = null
    private var mPButton: ImageButton? = null
    private var mRButton: ImageButton? = null
    private var mSButton: ImageButton? = null
    private var mTButton: ImageButton? = null
    private var mUVButton: ImageButton? = null
    private var mWButton: ImageButton? = null
    private var mXButton: ImageButton? = null
    private var mYQButton: ImageButton? = null
    private var mZButton: ImageButton? = null
    private var mSwitchButton: Button? = null
    private var mSpaceButton: Button? = null
    private var mDeleteButton: Button? = null

    private var m0Button: ImageButton? = null
    private var m1Button: ImageButton? = null
    private var m2Button: ImageButton? = null
    private var m3Button: ImageButton? = null
    private var m3AltButton: ImageButton? = null
    private var m4Button: ImageButton? = null
    private var m4AltButton: ImageButton? = null
    private var m5Button: ImageButton? = null
    private var m5AltButton: ImageButton? = null
    private var m6Button: ImageButton? = null
    private var m6AltButton: ImageButton? = null
    private var m7Button: ImageButton? = null
    private var m7AltButton: ImageButton? = null
    private var m8Button: ImageButton? = null
    private var m9Button: ImageButton? = null
    private var m10Button: ImageButton? = null
    private var mSwitch2Button: Button? = null
    private var mSpace2Button: Button? = null
    private var mDelete2Button: Button? = null

    private var viewSwitch: ViewSwitcher? =  null

    // This will map the button resource id to the String value that we want to
    // input when that button is clicked.
    private var keyValues = SparseArray<String>()

    // Our communication link to the EditText
    private var inputCon: InputConnection? = null

    // constructors
    init {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {

        // initialize buttons
        LayoutInflater.from(context).inflate(R.layout.keyboard, this, true)
        mAButton = findViewById<View>(R.id.AButton) as ImageButton
        mBButton = findViewById<View>(R.id.BButton) as ImageButton
        mCButton = findViewById<View>(R.id.CButton) as ImageButton
        mDButton = findViewById<View>(R.id.DButton) as ImageButton
        mEButton = findViewById<View>(R.id.EButton) as ImageButton
        mFButton = findViewById<View>(R.id.FButton) as ImageButton
        mGButton = findViewById<View>(R.id.GButton) as ImageButton
        mHButton = findViewById<View>(R.id.HButton) as ImageButton
        mIButton = findViewById<View>(R.id.IButton) as ImageButton
        mJButton = findViewById<View>(R.id.JButton) as ImageButton
        mKQButton = findViewById<View>(R.id.KQButton) as ImageButton
        mLButton = findViewById<View>(R.id.LButton) as ImageButton
        mMButton = findViewById<View>(R.id.MButton) as ImageButton
        mNButton = findViewById<View>(R.id.NButton) as ImageButton
        mOButton = findViewById<View>(R.id.OButton) as ImageButton
        mPButton = findViewById<View>(R.id.PButton) as ImageButton
        mRButton = findViewById<View>(R.id.RButton) as ImageButton
        mSButton = findViewById<View>(R.id.SButton) as ImageButton
        mTButton = findViewById<View>(R.id.TButton) as ImageButton
        mUVButton = findViewById<View>(R.id.UVButton) as ImageButton
        mWButton = findViewById<View>(R.id.WButton) as ImageButton
        mXButton = findViewById<View>(R.id.XButton) as ImageButton
        mYQButton = findViewById<View>(R.id.YButton) as ImageButton
        mZButton = findViewById<View>(R.id.ZButton) as ImageButton
        mSwitchButton = findViewById<View>(R.id.button_switch) as Button
        mSpaceButton = findViewById<View>(R.id.button_space) as Button
        mDeleteButton = findViewById<View>(R.id.button_delete) as Button

        m0Button = findViewById<View>(R.id.n0Button) as ImageButton
        m1Button = findViewById<View>(R.id.n1Button) as ImageButton
        m2Button = findViewById<View>(R.id.n2Button) as ImageButton
        m3Button = findViewById<View>(R.id.n3Button) as ImageButton
        m3AltButton = findViewById<View>(R.id.n3AltButton) as ImageButton
        m4Button = findViewById<View>(R.id.n4Button) as ImageButton
        m4AltButton = findViewById<View>(R.id.n4AltButton) as ImageButton
        m5Button = findViewById<View>(R.id.n5Button) as ImageButton
        m5AltButton = findViewById<View>(R.id.n5AltButton) as ImageButton
        m6Button = findViewById<View>(R.id.n6Button) as ImageButton
        m6AltButton = findViewById<View>(R.id.n6AltButton) as ImageButton
        m7Button = findViewById<View>(R.id.n7Button) as ImageButton
        m7AltButton = findViewById<View>(R.id.n7AltButton) as ImageButton
        m8Button = findViewById<View>(R.id.n8Button) as ImageButton
        m9Button = findViewById<View>(R.id.n9Button) as ImageButton
        m10Button = findViewById<View>(R.id.n10Button) as ImageButton
        mSwitch2Button = findViewById<View>(R.id.button_switch2) as Button
        mSpace2Button = findViewById<View>(R.id.button_space2) as Button
        mDelete2Button = findViewById<View>(R.id.button_delete2) as Button

        viewSwitch = findViewById<ViewSwitcher>(R.id.switcher)!!

        // set button click rs
        mAButton!!.setOnClickListener(this)
        mBButton!!.setOnClickListener(this)
        mCButton!!.setOnClickListener(this)
        mDButton!!.setOnClickListener(this)
        mEButton!!.setOnClickListener(this)
        mFButton!!.setOnClickListener(this)
        mGButton!!.setOnClickListener(this)
        mHButton!!.setOnClickListener(this)
        mIButton!!.setOnClickListener(this)
        mJButton!!.setOnClickListener(this)
        mKQButton!!.setOnClickListener(this)
        mLButton!!.setOnClickListener(this)
        mMButton!!.setOnClickListener(this)
        mNButton!!.setOnClickListener(this)
        mOButton!!.setOnClickListener(this)
        mPButton!!.setOnClickListener(this)
        mRButton!!.setOnClickListener(this)
        mSButton!!.setOnClickListener(this)
        mTButton!!.setOnClickListener(this)
        mUVButton!!.setOnClickListener(this)
        mWButton!!.setOnClickListener(this)
        mXButton!!.setOnClickListener(this)
        mYQButton!!.setOnClickListener(this)
        mZButton!!.setOnClickListener(this)
        mSwitchButton!!.setOnClickListener(this)
        mSpaceButton!!.setOnClickListener(this)
        mDeleteButton!!.setOnClickListener(this)

        m0Button!!.setOnClickListener(this)
        m1Button!!.setOnClickListener(this)
        m2Button!!.setOnClickListener(this)
        m3Button!!.setOnClickListener(this)
        m3AltButton!!.setOnClickListener(this)
        m4Button!!.setOnClickListener(this)
        m4AltButton!!.setOnClickListener(this)
        m5Button!!.setOnClickListener(this)
        m5AltButton!!.setOnClickListener(this)
        m6Button!!.setOnClickListener(this)
        m6AltButton!!.setOnClickListener(this)
        m7Button!!.setOnClickListener(this)
        m7AltButton!!.setOnClickListener(this)
        m8Button!!.setOnClickListener(this)
        m9Button!!.setOnClickListener(this)
        m10Button!!.setOnClickListener(this)
        mSwitch2Button!!.setOnClickListener(this)
        mSpace2Button!!.setOnClickListener(this)
        mDelete2Button!!.setOnClickListener(this)


        // map buttons IDs to input strings
        keyValues.put(R.id.AButton, "A")
        keyValues.put(R.id.BButton, "B")
        keyValues.put(R.id.CButton, "C")
        keyValues.put(R.id.DButton, "D")
        keyValues.put(R.id.EButton, "E")
        keyValues.put(R.id.FButton, "F")
        keyValues.put(R.id.GButton, "G")
        keyValues.put(R.id.HButton, "H")
        keyValues.put(R.id.IButton, "I")
        keyValues.put(R.id.JButton, "J")
        keyValues.put(R.id.KQButton, "Q")
        keyValues.put(R.id.LButton, "L")
        keyValues.put(R.id.MButton, "M")
        keyValues.put(R.id.NButton, "N")
        keyValues.put(R.id.OButton, "O")
        keyValues.put(R.id.PButton, "P")
        keyValues.put(R.id.RButton, "R")
        keyValues.put(R.id.SButton, "S")
        keyValues.put(R.id.TButton, "T")
        keyValues.put(R.id.UVButton, "V")
        keyValues.put(R.id.WButton, "W")
        keyValues.put(R.id.XButton, "X")
        keyValues.put(R.id.YButton, "Y")
        keyValues.put(R.id.ZButton, "Z")
        keyValues.put(R.id.button_space, " ")

        keyValues.put(R.id.n0Button, "0")
        keyValues.put(R.id.n1Button, "1")
        keyValues.put(R.id.n2Button, "2")
        keyValues.put(R.id.n3Button, "3")
        keyValues.put(R.id.n3AltButton, "3")
        keyValues.put(R.id.n4Button, "4")
        keyValues.put(R.id.n4AltButton, "4")
        keyValues.put(R.id.n5Button, "5")
        keyValues.put(R.id.n5AltButton, "5")
        keyValues.put(R.id.n6Button, "6")
        keyValues.put(R.id.n6AltButton, "6")
        keyValues.put(R.id.n7Button, "7")
        keyValues.put(R.id.n7AltButton, "7")
        keyValues.put(R.id.n8Button, "8")
        keyValues.put(R.id.n8Button, "8")
        keyValues.put(R.id.n9Button, "9")
        keyValues.put(R.id.n10Button, "10")
        keyValues.put(R.id.button_space2, " ")
    }

    override fun onClick(v: View) {

        // do nothing if the InputConnection has not been set yet
        if (inputCon == null) return

        // Delete text or input key value
        // All communication goes through the InputConnection
        if (v.id === R.id.button_delete || v.id === R.id.button_delete2) {
            val selectedText = inputCon!!.getSelectedText(0)
            if (TextUtils.isEmpty(selectedText)) {
                // no selection, so delete previous character
                inputCon!!.deleteSurroundingText(1, 0)
            } else {
                // delete the selection
                inputCon!!.commitText("", 1)
            }
        } else  if(v.id === R.id.button_switch){
            viewSwitch!!.showNext()
        } else  if(v.id === R.id.button_switch2){
            viewSwitch!!.showPrevious();
        } else {
            val value = keyValues[v.id]
            inputCon!!.commitText(value, 1)
        }
    }

    // The activity (or some parent or controller) must give us
    // a reference to the current EditText's InputConnection
    fun setInputConnection(ic: InputConnection?) {
        inputCon = ic
    }
}