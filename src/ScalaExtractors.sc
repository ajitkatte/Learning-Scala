import java.text.SimpleDateFormat
import java.util.Calendar

//This is regex which will extract the date in dd/mm/yyyy format to day month and year
val regex = "(\\d+)/(\\d+)/(\\d+)".r
val regex(day, month, year) = new SimpleDateFormat("dd/mm/yyyy").format(Calendar.getInstance.getTime)
println(s" Day: ${day} \n Month: ${month} \n Year: ${year}")