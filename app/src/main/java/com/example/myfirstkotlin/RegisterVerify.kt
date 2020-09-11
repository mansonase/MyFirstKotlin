package com.example.myfirstkotlin

class RegisterVerify {
    fun isLoginIdVerify(loginId:String):Boolean{
        var isLoginIdOK=false
        if (loginId.length>=6){
            if (loginId.toUpperCase().first() in 'A'..'Z'){
                isLoginIdOK=true
            }
        }
        return isLoginIdOK
    }

    fun isLoginPwdVerify(loginPwd:String):Boolean{
        var isPwdOK=false
        if (loginPwd.length>=8){
            if (loginPwd.toUpperCase().first() in 'A'..'Z'){
                if (loginPwd.findAnyOf((0..9).map { it.toString() })!==null){
                    isPwdOK=true
                }
            }
        }
        return isPwdOK
    }
}