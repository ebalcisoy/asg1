import java.io.IOException;
import java.util.StringTokenizer;
 
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class WordMapper extends Mapper<Object, Text, Text, IntWritable> {
 private Text word = new Text();
 private final static IntWritable one = new IntWritable(1);
  
 @Override
 public void map(Object key, Text value, Context context_W) throws IOException, InterruptedException {
  // Convert Text to String
  String line = value.toString();
  //sasasas
  // Clean up the string - remove all non alpha characters
  //line = line.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
  line = line.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();
  // Break line into words for processing
  StringTokenizer wordList = new StringTokenizer(line);
  while (wordList.hasMoreTokens()) {
   word.set(wordList.nextToken());
   context_W.write(word, one);
  }
 }
}
