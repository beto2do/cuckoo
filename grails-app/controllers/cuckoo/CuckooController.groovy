package cuckoo

class CuckooController {

    def cuckooService

    static responseFormats = ['json', 'html']
    def getOutputByHour() {
      def date = new Date(params.date)
      def hours = date.format("hh")
      def minutes = date.format('mm')
      respond( cuckooService.determineSound(hours, minutes) )
    }
}
