//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            n = a2.length;
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }

            int ans = new Solution().maxMeetings(a, b);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    
    // class Intervals{
    //     int start;
    //     int end;
        
        
    //     public getIntervals(){
            
    //         return Arrays.asList(start,end);
    //     }
        
    //     public setIntervals(int start,int end){
    //         this.start= start;
    //         this.end = end;
    //     }
    // }
    
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        // create intervals first
        
        // now dump the value
        
        // for(int i=0;i<start.length;i++){
            
        // }
        
        List<List<Integer>> intervals = new ArrayList<>();
        int meetingCount = 0;
        
        for(int i=0;i<start.length;i++){
            intervals.add(Arrays.asList(start[i],end[i]));
        }
        
        Collections.sort(intervals,(a,b)->a.get(1)-b.get(1)); // sort on second
        
        // now storing the first meeting and meeting count is 1
        
        List<Integer> meeting = intervals.get(0);
        meetingCount++;
        
        for(int i=1;i<intervals.size();i++){
            
            int currentStart= intervals.get(i).get(0);
            int currentEnd = intervals.get(i).get(1);
            
            int meetingEnd = meeting.get(1);
            
            // checking non overlappping
            
            if(currentStart>meetingEnd){
                meetingCount++;
                meeting.set(0,currentStart);
                meeting.set(1,currentEnd);
                
            }
        }
        
        return meetingCount;
        
        
    }
}
