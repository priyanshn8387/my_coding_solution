class MedianFinder {
    
    PriorityQueue<Integer> leftMax = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> rightMin = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(leftMax.isEmpty() || num<=leftMax.peek()){
            leftMax.offer(num);
        }else{
            rightMin.offer(num);
        }

        // now checking condition
         // Step 2: balance the heaps
        if (leftMax.size()-rightMin.size()>1) {
            rightMin.offer(leftMax.poll());
        } 
        else if (rightMin.size() > leftMax.size()) {
            leftMax.offer(rightMin.poll());
        }
    }
    
    public double findMedian() {
        if(leftMax.size()==rightMin.size()) return (leftMax.peek()+rightMin.peek())/2.0;
        else return leftMax.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */