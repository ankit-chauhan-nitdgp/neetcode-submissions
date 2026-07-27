/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        val sortedInterval = intervals.sortedBy{
            it.start
        }

        var end = -1
        for(interval: Interval in sortedInterval){
            if(interval.start < end){
                return false
            }
            end = interval.end
        }

        return true
    }
}
