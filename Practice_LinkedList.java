import java.util.*;

public class Practice_LinkedList{
    public static void main(String[] args){
        LinkedList biglist = new LinkedList();
        for(int x = 10; x >=0; x--){
            biglist.add(x);
        }

        LinkedList emptylist = new LinkedList();

        LinkedList list1 = new LinkedList();
        list1.add(7);

        LinkedList list2 = new LinkedList();
        list2.add(8);
        list2.add(8);
        list2.add(biglist.GetHead().GetNext());

        System.out.println("Big List:");
        biglist.print();
        list2.print();

        Node intersect = GetInstersection(biglist,list2);
        System.out.println(intersect.GetVal());
        intersect = GetInstersection(list2,biglist);
        System.out.println(intersect.GetVal());

        intersect = GetInstersection(list1,list2);

        if(intersect != null){
            System.out.println(intersect.GetVal());
        }else{
            System.out.println("No Intersection");
        }

        intersect = GetInstersection(list1,emptylist);

        if(intersect != null){
            System.out.println(intersect.GetVal());
        }else{
            System.out.println("No Intersection");
        }

    }

    public static Node GetInstersection(LinkedList ll1, LinkedList ll2){
        int lengthDiff = ll1.length() - ll2.length();
        Node cur1 = ll1.GetHead();
        Node cur2 = ll2.GetHead();
        if(lengthDiff > 0){
            while(lengthDiff > 0){
                cur1 = cur1.GetNext();
                lengthDiff--;
            }
        }else if(lengthDiff < 0){
            while(lengthDiff < 0){
                cur2 = cur2.GetNext();
                lengthDiff++;
            }
        }
        while(cur1 != null){
            if(cur1 == cur2){
                return cur1;
            }
            cur1 = cur1.GetNext();
            cur2 = cur2.GetNext();
        }
        return null;
    }
    public static Integer SumLinkedLists(LinkedList ll1, LinkedList ll2){
    	Stack<Integer> s1 = new Stack<Integer>();
    	Stack<Integer> s2 = new Stack<Integer>();

    	Node loc1 = ll1.GetHead();
    	Node loc2 = ll2.GetHead();

    	while(loc1 != null){
    		s1.push(loc1.GetVal());
    		loc1 = loc1.GetNext();
    	}

    	while(loc2 != null){
    		s2.push(loc2.GetVal());
    		loc2 = loc2.GetNext();
    	}

    	int mult = 1;
    	int sum = 0;
    	while(!s1.empty() || !s2.empty()){
    		if(!s1.empty()){
    			sum += s1.pop() * mult;
    		}
    		if(!s2.empty()){
    			sum += s2.pop() * mult;
    		}
    		mult = mult * 10;
    	}

    	return sum;
    }

    static class LinkedList{

		private Node head;

		public LinkedList(){
			this.head = null;
		}

		public Node GetHead(){
			return head;
		}

		public void add(int padd){
			if(this.head == null){
				this.head = new Node(padd);
			}else{
				Node loc = this.head;
				while(loc.GetNext() != null){
					loc = loc.GetNext();
				}
				loc.SetNext(new Node(padd));
			}
		}

		public void add(Node pnode){
			if(this.head == null){
				this.head = pnode;
			}else{
				Node loc = this.head;
				while(loc.GetNext() != null){
					loc = loc.GetNext();
				}
				loc.SetNext(pnode);
			}
		}

        public void remove(int val){
            Node cur = this.head;
            Node prev = null;
            while(cur != null){
                Node next = cur.GetNext();
                if(cur.GetVal()==val){
                    if(prev==null){
                        this.head = next;
                    }else{
                        prev.SetNext(next);
                    }
                }else{
                    prev = cur;
                }
                cur = next;
            }
        }

        public void sort(){
            Node cur = this.head;
            while(cur != null){
                Node next = cur.GetNext();
                while(next != null){
                    if(next.GetVal() < cur.GetVal()){
                        //swap next and cur
                        int temp = next.GetVal();
                        next.SetVal(cur.GetVal());
                        cur.SetVal(temp);
                    }
                    next = next.GetNext();
                }
                cur = cur.GetNext();
            }
        }

		public void print(){
			Node loc = head;
			while(loc != null){
				System.out.print(loc.GetVal() + " ");
				loc = loc.GetNext();
			}
            System.out.println();
		}

        public void printReverse(){
            Stack<Integer> s1 = new Stack<Integer>();
            Node cur = this.head;
            while(cur!=null){
                s1.push(cur.GetVal());
                cur = cur.GetNext();
            }
            while(!s1.empty()){
                System.out.println(s1.pop());
            }
        }

        public void DeleteAlternating(){
            Node loc = this.head;
            if(loc != null){
                Node next = loc.GetNext();
                while(next != null){
                    loc.SetNext(next.GetNext());
                    loc = loc.GetNext();
                    if(loc != null){
                        next = loc.GetNext();
                    }else{
                        next = null;
                    }
                }
            }
        }

        public int FrequencyOfK(int k){
            int freq = 0;
            Node loc = this.head;
            while(loc != null){
                if(loc.GetVal()==k){
                    freq++;
                }

                loc = loc.GetNext();
            }
            return freq;
        }

        public void SwapEveryTwo(){
            Node cur = this.head;
            if(cur != null){
                Node next = cur.GetNext();
                this.head = next;
                Node last = null;
                while(next != null){
                    if(last != null){
                        last.SetNext(next);
                    }
                    cur.SetNext(next.GetNext());
                    next.SetNext(cur);
                    last = cur;
                    cur = cur.GetNext();
                    if(cur != null){
                        next = cur.GetNext();
                    }else{
                        next = null;
                    }
                }
            }
        }

        public boolean SortedDesc(){
            if(this.head == null){
                return true;
            }else{
                return SortedDescRecur(this.head.GetVal(),this.head.GetNext());
            }
        }

        private boolean SortedDescRecur(int lastval, Node cur){
            if(cur==null){
                return true;
            }
            if(cur.GetVal() <= lastval){
                return SortedDescRecur(cur.GetVal(), cur.GetNext());
            }
            return false;
        }

		public boolean Exists(Node pnode){
			Node loc = this.head;
			while(loc!=null){
				if(loc == pnode){
					return true;
				}else{
					loc = loc.GetNext();
				}
			}
			return false;
		}

		public int GetMidValue(){
	    	if(this.head!=null){
	    		Node it_mid = this.head;
		    	Node it_end = this.head;
		    	int mid_val = it_mid.GetVal();
		    	while(it_end.GetNext()!=null){
		    		it_end = it_end.GetNext();
		    		if(it_end.GetNext()!=null){
		    			it_end = it_end.GetNext();
		    			it_mid = it_mid.GetNext();
		    			mid_val = it_mid.GetVal();
		    		}else{
		    			break;
		    		}
		    	}
	    		return mid_val;
	    	}else{
	    		return 0;
	    	}
    	}

    	public void Reverse(){
    		if(this.head!=null){
    			Node cur = this.head;
    			Node last = null;
    			Node next = null;
    			while(cur != null){
    				//Set next for current to the last one & update pointers
    				next = cur.GetNext();
    				cur.SetNext(last);
    				last = cur;
    				cur = next;
    			}
    			//Reach the end. Set head = last
    			this.head = last;
    		}
    	}

    	public void ReverseRecursively(){
    		if(this.head!=null){
    			Node next = this.head.GetNext();
    			this.head.SetNext(null);
    			ReverseNode(this.head, next);
    		}
    	}

    	public void ReverseNode(Node curNode,Node nextNode){
    		if(nextNode==null){
    			this.head = curNode;
    		}else{
    			ReverseNode(nextNode,nextNode.GetNext());
    			nextNode.SetNext(curNode);
    		}
    	}

    	public Boolean HasLoop(){
    		if(this.head!=null){
    			Node slow = this.head;
    			Node fast = this.head;
    			while(fast.GetNext() != null){
    				fast = fast.GetNext();
    				if(fast == slow){
    					return true;
    				}else{
    					if(fast.GetNext()!=null){
    						fast = fast.GetNext();
    						slow = slow.GetNext();
    					}else{
    						return false;
    					}
    				}
    			}
    		}
    		return false;
    	}

    	public Node StartOfLoop(){
			if(this.head!=null){
    			Node slow = this.head;
    			Node fast = this.head;
    			while(fast.GetNext() != null){
    				fast = fast.GetNext();
    				if(fast == slow){
    					//Set slow = head, move fast to next
    					slow = this.head;
    					fast = fast.GetNext();
    					//Iterate each by 1 until they meet
    					while(slow != fast){
    						System.out.println(slow.GetVal() + fast.GetVal());
    						slow = slow.GetNext();
    						fast = fast.GetNext();
    					}
    					return slow;
    				}else{
    					if(fast.GetNext()!=null){
    						fast = fast.GetNext();
    						slow = slow.GetNext();
    					}else{
    						return null;
    					}
    				}
    			}
    		}
    		return null;
    	}

    	public void RemoveDuplicates(){
    		HashSet<Integer> hs = new HashSet<Integer>();
    		Node loc = this.head;
    		Node last = null;
    		while(loc != null){
    			if(hs.contains(loc.GetVal())){
    				//Remove from list by setting last's next equal to current next
    				loc = loc.GetNext();
    				last.SetNext(loc);
    			}else{
    				hs.add(loc.GetVal());
    				last = loc;
    				loc = loc.GetNext();
    			}
    		}
    	}

    	public int length(){
    		int length = 0;
    		Node loc = this.head;
    		while(loc != null){
    			length++;
    			loc = loc.GetNext();
    		}
    		return length;
    	}

    	public Node KthNodeFromEnd(int k){
    		Node kth = null;
    		Node last = this.head;
    		while(last != null && k > 0){
                last = last.GetNext();
                k--;
            }
            if(k <= 0){
                kth = this.head;
            }
            while(last != null){
                kth = kth.GetNext();
                last = last.GetNext();
            }
    		return kth;
    	}
	}

	static class Node{
			private int val;
			private Node next;

			public Node(){
				val = 0;
				next = null;
			}

			public Node(int pval){
				val = pval;
				next = null;
			}

			public void SetVal(int pval){
				val = pval;
			}

			public void SetNext(Node pnext){
				next = pnext;
			}

			public int GetVal(){
				return val;
			}

			public Node GetNext(){
				return next;
			}
		}
}


