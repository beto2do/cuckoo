package cuckoo

class CuckooController {

    static responseFormats = ['json', 'html']
    def getOutputByHour() {
      def date = params.date
      respond( [] )
    }
}
