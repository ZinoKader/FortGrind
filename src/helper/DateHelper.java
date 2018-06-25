package helper;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateHelper {

    public static String getTimeStamp() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofLocalizedDateTime( FormatStyle.MEDIUM )
                        .withLocale( Locale.UK)
                        .withZone( ZoneId.systemDefault() );
        return formatter.format(Instant.now());
    }
}
