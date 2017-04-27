package cuckoo

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(CuckooService)
class CuckooServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "can I Say Fizz"() {
        expect:"divisible between 3"
            service.canISayFizz(9)
    }

    void "can I Say Buzz"(){
      expect: "divisible between 5"
        service.canISayBuzz(15)
    }

    void "is O'clock"(){
      expect: "hour o'clock"
        service.isOclock(0)
    }

    void "is Half Hour"(){
      expect: "minutes are 30 minutes"
        service.isHalfHour(30)
    }

    void "generate Cuckoos"(){
      expect: "create cuckoos by hours"
        service.generateCuckoos(1) == "Cuckoo "
    }

    void "sound tick"(){
      expect: "Sound to show by hours and minutes"
        service.determineSound(13,34).msg == "tick"
    }

    void "sound o'clock"(){
      expect: "Sound to show by hours and minutes"
        service.determineSound(9,00).msg == "Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo "
    }

    void "sound Fizz Buzz"(){
      expect: "Sound to show by hours and minutes"
        service.determineSound(11,15).msg == "Fizz Buzz"
    }

    void "sound Fizz"(){
      expect: "Sound to show by hours and minutes"
        service.determineSound(03,03).msg == "Fizz"
    }

    void "sound Fizz"(){
      expect: "Sound to show by hours and minutes"
        service.determineSound(14,30).msg == "Cuckoo"
    }

    void "sound Buzz"(){
      expect: "Sound to show by hours and minutes"
        service.determineSound(8,55).msg == "Buzz"
    }

    void "sound Buzz"(){
      expect: "Sound to show by hours and minutes"
        service.determineSound(12,00).msg == "Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo "
    }
}
