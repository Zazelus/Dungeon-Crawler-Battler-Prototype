package com.javaCrawl.dungeons;

import com.javaCrawl.player.Player;
import com.javaCrawl.rooms.BossRoom;
import com.javaCrawl.rooms.EmptyRoom;
import com.javaCrawl.rooms.KeyRoom;
import com.javaCrawl.rooms.MonsterRoom;
import com.javaCrawl.rooms.RestRoom;
import com.javaCrawl.rooms.Room;
import com.javaCrawl.rooms.TrapRoom;
import com.javaCrawl.rooms.TreasureRoom;

/**
 * Reads the String array that was converted from the text document
 * and assigns events based at each location depending on the string
 * contained at each index of the array.
 *
 * @author Zaezul
 * @version 04.20.20
 */
public class FloorParser {

	private Room[][] parsedFloor;

	private static int height;
	private static int width;

	/**
	 * Creates a new FloorParser object.
	 *
	 * @param dungeonFloor	is the dungeon to be parsed for events.
	 * @throws InterruptedException
	 */
	public FloorParser(Player player, String[][] dungeonFloor, int floorNumber) throws InterruptedException {
		parsedFloor = parseFloorData(player, dungeonFloor, floorNumber);
	}

	/**
	 * Assigns an event to a an event array based on the string in the
	 * corresponding index in the dungeonFloor array.
	 *
	 * As the floorNumber increases beyond 1, the game becomes more
	 * challenging and rewarding.
	 *
	 * @return the parsed array with events.
	 * @throws InterruptedException
	 */
	public static Room[][] parseFloorData(Player player, String[][] dungeonFloor, int floorNumber) throws InterruptedException {
		height = dungeonFloor.length;
		width = dungeonFloor[0].length;

		Room[][] populatedFloor = new Room[height][width];

		for (int i = 0; i < height; i++) {
			for (int k = 0; k < width; k++) {
				switch (dungeonFloor[i][k]) {
					case "S":
						//populatedFloor[i][k] = new StartRoom();
				    case "E":
					    populatedFloor[i][k] = new EmptyRoom(player);
					    break;
				    case "M":
					    populatedFloor[i][k] = new MonsterRoom(player, floorNumber);
					    break;
				    case "T":
				    	populatedFloor[i][k] = new TreasureRoom(player, floorNumber);
				    	break;
				    case "B":
				    	populatedFloor[i][k] = new BossRoom(player, floorNumber);
				    	break;
				    /*case "V":
				    	populatedFloor[i][k] = new VendorRoom(floorNumber);
				    	break;*/
				    case "D":
				    	populatedFloor[i][k] = new EmptyRoom(player);; // TO-DO : Placeholder for now.
				    	break;
				    case "K":
				    	populatedFloor[i][k] = new KeyRoom(player);
				    	break;
				    case "R":
				    	populatedFloor[i][k] = new RestRoom(player, floorNumber);
				    	break;
				    case "!":
				    	populatedFloor[i][k] = new TrapRoom(player, floorNumber);
				}
			}
		}

		return populatedFloor;
	}

	/**
	 * Provides direct access to the parsed floor.
	 *
	 * @return the floor with events included.
	 */
	public Room[][] getParsedFloor() {
		return parsedFloor;
	}

}

