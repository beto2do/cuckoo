package cuckoo

import grails.transaction.Transactional

@Transactional
class CuckooService {

    def determineSound(hours, minutes) {
      int hoursInt = hours as Integer
      int minutesInt = minutes as Integer
      def message = "tick"

      if(canISayFizz(minutesInt)){
        message = "Fizz"
      }

      if(canISayBuzz(minutesInt)){
        message = "Buzz"
      }

      if(canISayFizz(minutesInt) && canISayBuzz(minutesInt)){
        message = "Fizz Buzz"
      }

      if(isOclock(minutesInt)){
        message = generateCuckoos(hoursInt)
      }

      if(isHalfHour(minutesInt)){
        message = "cuckoo"
      }
      
      [msg: message]
    }

    def canISayFizz(minutes) {
      minutes % 3 == 0
    }

    def canISayBuzz(minutes){
      minutes % 5 == 0
    }

    def isOclock(minutes){
      minutes == 0
    }

    def isHalfHour(minutes){
      minutes == 30
    }

    def generateCuckoos(hours){
      def message = ""
      (1..hours).each {
          message += "cuckoo "
      }
      message
    }
}
