package com.example.singletonsesignpattern

import java.util.logging.FileHandler
import java.util.logging.Logger

class LoggerOperation {
    public var logg : Logger? = null

    private constructor(){
        logg = Logger.getLogger("file_logger")
        logg!!.addHandler(FileHandler("log.txt"))
     }

    companion object{
        private var logger : LoggerOperation? = null

        public fun getLoggerInstance () : LoggerOperation {
            if ( logger == null ) {
                logger = LoggerOperation()
            }
            return logger!!
         }
    }


}