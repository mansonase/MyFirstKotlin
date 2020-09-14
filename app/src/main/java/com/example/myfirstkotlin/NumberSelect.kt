package com.example.myfirstkotlin

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

interface NumberSelectListener{
    fun onValueChange(value:Int)
}

class NumberSelect:LinearLayout {

    private lateinit var addButton:Button
    private lateinit var minusButton: Button
    private lateinit var valueTextView:TextView

    private var minValue:Int=0
    private var maxValue:Int=0
    private var defaultValue:Int=0
    var textValue:Int=0


    private var listener:NumberSelectListener?=null

    constructor(context: Context) : super(context){
        init(context, null)
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
        init(context, attrs)
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        init(context, attrs)
    }

    private fun init(context: Context,attrs: AttributeSet?){
        View.inflate(context,R.layout.numberselect,this)
        descendantFocusability=ViewGroup.FOCUS_BLOCK_DESCENDANTS
        this.addButton=findViewById(R.id.addButton)
        this.minusButton=findViewById(R.id.minusButton)
        this.valueTextView=findViewById(R.id.valueTextView)

        this.textValue=0
        this.maxValue=Integer.MAX_VALUE
        this.minValue=0

        if (attrs!=null){
            val attributes=context.theme.obtainStyledAttributes(attrs,R.styleable.NumberSelect,0,0)

            this.maxValue=attributes.getInt(R.styleable.NumberSelect_max_value,this.maxValue)
            this.minValue=attributes.getInt(R.styleable.NumberSelect_min_value,this.minValue)
            this.defaultValue=attributes.getInt(R.styleable.NumberSelect_default_value,0)

            this.valueTextView.text=defaultValue.toString()
            this.textValue=defaultValue
        }

        this.addButton.setOnClickListener {
            addTextValue()
            if (listener!=null){
                listener!!.onValueChange(textValue)
            }
        }
        this.minusButton.setOnClickListener {
            minusTextValue()
            if (listener!=null){
                listener!!.onValueChange(textValue)
            }
        }
    }

    fun setMaxValue(value: Int){
        this.maxValue=value
    }
    fun setMinValue(value: Int){
        this.minValue=value
    }
    fun setDefaultValue(value: Int){
        this.defaultValue=value
        this.textValue=value
    }

    private fun addTextValue(){
        if (this.textValue<this.maxValue){
            this.textValue++
            this.valueTextView.text=this.textValue.toString()
        }
    }
    private fun minusTextValue(){
        if (this.textValue>this.minValue){
            this.textValue--
            this.valueTextView.text=this.textValue.toString()
        }
    }
    fun setListener(listener: NumberSelectListener){
        this.listener=listener
    }
}