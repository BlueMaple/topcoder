package com.srm144.div1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PenLift_ryanpmiller {
	private class Point {
		int x;
		int y;
	}

	public enum Direction {
		VERTICAL, HORIZONTAL
	}

	private class Segment {
		Point start;
		Point end;
		Direction direction;
	}

	private class Shape {
		int id;
		List<Segment> segments = new ArrayList<Segment>();
		int endpoints = 0;
	}

	Map<Integer, Shape> shapes = null;
	int nextShapeId = 0;

	public int numTimes(String[] segments, int n) {
		List<Segment> segs = combineOverlappingSegments(organizeSegments(segments));
		shapes = new HashMap<Integer, Shape>();
		for (int i = 0; i < segs.size(); i++) {
			Shape shape = getShapeForSegment(segs.get(i));
			for (int j = i + 1; j < segs.size(); j++) {
				Shape shape2 = getShapeForSegment(segs.get(j));

				if (segs.get(i).direction == Direction.VERTICAL
						&& segs.get(j).direction == Direction.HORIZONTAL) {
					if ((segs.get(i).start.y == segs.get(j).start.y || segs
							.get(i).end.y == segs.get(j).start.y)
							&& (segs.get(j).start.x == segs.get(i).start.x || segs
									.get(j).end.x == segs.get(i).start.x)) {
						shape = combineShapes(shape, shape2, true);
					} else if ((segs.get(i).start.y <= segs.get(j).start.y || segs
							.get(i).end.y >= segs.get(j).start.y)
							&& (segs.get(j).start.x <= segs.get(i).start.x || segs
									.get(j).end.x >= segs.get(i).start.x)) {
						shape = combineShapes(shape, shape2, false);
					}
				}
			}
			shapes.put(shape.id, shape);
		}
		if (n % 2 == 0) {
			return shapes.size() - 1;
		}
		int totalPenLitfs = 0;
		for (Shape shape : shapes.values()) {
			totalPenLitfs += Math.max(1, shape.endpoints);
		}
		return totalPenLitfs - 1;
	}

	private List<Segment> organizeSegments(String[] segments) {
		List<Segment> segs = new ArrayList<Segment>();
		for (String segment : segments) {
			String[] parts = segment.split(" ");

			Point start = new Point();
			start.x = Math.min(Integer.valueOf(parts[0]),
					Integer.valueOf(parts[2]));
			start.y = Math.min(Integer.valueOf(parts[1]),
					Integer.valueOf(parts[3]));

			Point end = new Point();
			end.x = Math.max(Integer.valueOf(parts[0]),
					Integer.valueOf(parts[2]));
			end.y = Math.max(Integer.valueOf(parts[1]),
					Integer.valueOf(parts[3]));

			Segment seg = new Segment();
			seg.start = start;
			seg.end = end;
			seg.direction = start.x == end.x ? (Direction.VERTICAL)
					: (Direction.HORIZONTAL);

			segs.add(seg);
		}
		return segs;
	}

	private List<Segment> combineOverlappingSegments(List<Segment> segments) {
		List<Segment> combined = new ArrayList<Segment>();
		for (Segment segment : segments) {
			Iterator<Segment> iterator = combined.iterator();
			while (iterator.hasNext()) {
				Segment other = iterator.next();
				if (segment.direction == Direction.VERTICAL
						&& other.direction == Direction.VERTICAL
						&& segment.start.x == other.start.x
						&& segment.start.y <= other.end.y
						&& segment.end.y >= other.start.y) {
					segment.start.y = Math.min(segment.start.y, other.start.y);
					segment.end.y = Math.max(segment.end.y, other.end.y);
					iterator.remove();
				}
				if (segment.direction == Direction.HORIZONTAL
						&& other.direction == Direction.HORIZONTAL
						&& segment.start.y == other.start.y
						&& segment.start.x <= other.end.x
						&& segment.end.x >= other.start.x) {
					segment.start.x = Math.min(segment.start.x, other.start.x);
					segment.end.x = Math.max(segment.end.x, other.end.x);
					iterator.remove();
				}
			}
			combined.add(segment);
		}
		return combined;
	}
	
	private Shape getShapeForSegment(Segment segment){
		Shape shape = null;
		for(Shape existingShape : shapes.values()){
			if(existingShape.segments.contains(segment)){
				shape = existingShape;
				break;
			}
		}
		if(shape == null){
			shape = new Shape();
			shape.id = nextShapeId++;
			shape.segments.add(segment);
			shape.endpoints = 1;
			shapes.put(shape.id, shape);
		}
		
		return shape;
	}
	
	private Shape combineShapes(Shape shapeOne , Shape shapeTwo , boolean attachOnEndpoint){
		if(shapeOne != shapeTwo){
			shapeOne.segments.addAll(shapeTwo.segments);
			shapeOne.endpoints += shapeTwo.endpoints;
			shapes.remove(shapeTwo.id);
		}
		if(attachOnEndpoint){
			--shapeOne.endpoints;
		}
		
		return shapeOne;
	}
}
