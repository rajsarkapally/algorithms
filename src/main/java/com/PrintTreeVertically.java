package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class PrintTreeVertically {
/*
Given the root of a binary tree containing integers, print the columns of the tree in order with the nodes in each column printed top-to-bottom.


# Input:
#       6
#      / \
#     3   4
#    / \   \
#   5   1   0
#  / \     /
# 9   2   8
#      \
#       7

# Output:
# 9 5 3 2 6 1 7 4 8 0


*/
	
	public static void main(String[] args){
		
		Node node7 = new Node(7, null, null);
		Node node2 = new Node(2, null, node7);
		Node node9 = new Node(9, null, null);
		Node node5 = new Node(5, node9, node2);
		Node node1 = new Node(1, null, null);
		Node node3 = new Node(3, node5, node1);
		Node node8 = new Node(8, null, null);
		Node node0 = new Node(0, node8, null);
		Node node4 = new Node(4, null, node0);
		Node node6 = new Node(6, node3, node4);
		
		Map<Integer, List<Node>> result=getIndexedTree(node6);
		_printTreeVertically(result);
		
	}
	
	
	public static Map<Integer, List<Node>> getIndexedTree(Node root){
		Map<Integer, List<Node>> result = new HashMap();
		Map<Node, Integer> mapIndex = new HashMap();
		
		Queue<Node> queue = new LinkedList();
		queue.add(root);
		mapIndex.put(root, 0);
		
		while(!queue.isEmpty()){
			Node node = queue.poll();
			_putNodeNIndex(result, node, mapIndex.get(node)); 
			int nodeIndex = mapIndex.get(node);
			if(node.leftChild !=null){
				mapIndex.put(node.leftChild, nodeIndex-1);
				queue.add(node.leftChild);
			}
			if(node.rightChild !=null){
				mapIndex.put(node.rightChild, nodeIndex+1);
				queue.add(node.rightChild);
			}
		}
		return result;
	}
	
	private static void _putNodeNIndex(Map<Integer, List<Node>> map, Node node, int index){
		if(map.get(index) == null){
			map.put(index, new ArrayList<Node>());
		}
		map.get(index).add(node); 
	}
	
	private static void _printTreeVertically(Map<Integer, List<Node>> result){
		
		//Find the smallest index in the map "result"
		int lowestIndex=Integer.MAX_VALUE;
		for(Integer i:result.keySet()){
			lowestIndex=Math.min(lowestIndex, i);
		}
		
		while(result.get(lowestIndex) !=null){
			List<Node> nodes = result.get(lowestIndex++);
			
			for(Node node:nodes){
				System.out.print(node.value + "  "); 
			}
		}
		
	}
	
}
