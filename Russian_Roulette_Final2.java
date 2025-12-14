import java.util.Scanner;
import java.util.Random;

public class Russian_Roulette_Final2 {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      Random r = new Random();
      Scanner s1 = new Scanner(System.in);
      
      //Input for are you ready loop:
      String ans;
      
      //Input for play again loop: 
      String play2;
      
      //Greetings: 
      System.out.println("~ Russian Roulette: Java Edition ~");
      System.out.print("Please enter your name: ");
      String player = s.nextLine();
      System.out.println("");
      System.out.println("Welcome to Russian Roulette, " + player + "!");
      
      System.out.println("\nGuidelines:");
      System.out.println("> Each player has 3 lives.");
      System.out.println("> Players take turns.");
      System.out.println("> If you shoot yourself and survive, you get another turn.");
      System.out.println("> The revolver has 6 bullet chambers.");
      System.out.println("> 1 bullet is randomly placed.");
      System.out.println("> Players will choose a special item.");
      System.out.println("> Each special item is unique and helpful.");
      System.out.println("> Each special item has different cooldowns.");
      System.out.println("> Luck, strategy, and courage will keep you alive!");
      System.out.println("");
   
      System.out.println("----------------------------------------------------");
        
      do { //are you ready do-while
         System.out.println("");
         System.out.println("Are you ready? (yes/no)");
         System.out.print(player + ": ");
         ans = s.nextLine();
      
         if (ans.equalsIgnoreCase("yes")) {
            do { //play again do-while
               String item_choice; 
               int item_choice2;
               String item_name = "";
               do { //item choice do-while 
               
                  System.out.println("");
                  System.out.println("Choose a special item card (1-3):");
                  System.out.println("1 - Energy drink = heals 1 life to the player.");
                  System.out.println("2 - Cigarette = doubles the next bullet's damage.");
                  System.out.println("3 - Magnifying glass = reveals the bullet's position.");
                  System.out.println("");
               
                  System.out.print(player + ": ");
                  item_choice = s.nextLine();
                  System.out.println("");
               
                  switch (item_choice) {
                     case "1":
                        item_name = "Energy drink";
                        break;
                     case "2":
                        item_name = "Cigarette";
                        break;
                     case "3":
                        item_name = "Magnifying glass";
                        break;
                     default:
                        System.out.println("[Invalid answer... Please choose between 1-3]");
                        break;
                  }
                     
                     
               } while (!item_choice.equals("3") && !item_choice.equals("2") && !item_choice.equals("1"));
                     
               System.out.println(player + " chose the " + item_name + "!"); 
               
               String item_name2 = "";
               item_choice2 = r.nextInt(3) + 1;
               switch (item_choice2) {
                  case 1:
                     item_name2 = "Energy drink";
                     break;
                  case 2:
                     item_name2 = "Cigarette";
                     break;
                  case 3:
                     item_name2 = "Magnifying glass";
                     break;
               }
               System.out.println("");
               System.out.println("The enemy chose the " + item_name2 + "!");
            
               System.out.println("\n[The game begins! Make your choices carefully...]");
               System.out.println("");
               
               int playerLife = 3, enemyLife = 3;
               int round = 1;
               
               //cooldown for player's special item
               int energyDrinkCooldown = 0;
               int cigaretteCooldown = 0;
               int magnifyingGlassCooldown = 0;
               
               //cooldown for enemy's special item
               int energyDrinkCooldown2 = 0;
               int cigaretteCooldown2 = 0;
               int magnifyingGlassCooldown2 = 0;
            
               
               boolean playerTurn = true; // Start with the player
            
               while (playerLife > 0 && enemyLife > 0) {
                    // Randomize bullet at the start of the round
                  int bullet = r.nextInt(6) + 1; //randomly chooses bullet's position
                  boolean roundContinues = true; // Flag to determine if the round ends
                  boolean bullet2 = false; //Flag to determin if the bullet is upgraded
                  
                                
                  System.out.println("----------------------------------------------------");
                  System.out.println("                      Round " + round + "                       ");
               
                  while (roundContinues) {
                     if (playerTurn) {
                            // Player's turn
                        System.out.println("----------------------------------------------------");
                        System.out.println("");
                        System.out.println("Your turn! What will you do?");
                        System.out.println("1 - Shoot yourself");
                        System.out.println("2 - Shoot the enemy");
                        
                        if (energyDrinkCooldown == 0 && cigaretteCooldown == 0 && magnifyingGlassCooldown == 0) {
                           System.out.println("3 - Use special item (ready)");
                           System.out.println("");
                        } else {
                           System.out.println("3 - Use special item (on cooldown)");
                        }
                        System.out.print("Enter your decision: ");
                        int decision = s.nextInt();
                        System.out.println("");
                        System.out.println("----------------------------------------------------");
                        System.out.println("");
                        if (decision == 1) { // Shoot yourself
                           System.out.println(player + " points the gun at themselves...");
                           System.out.print("1...");
                           try {
                           
                              Thread.sleep(1000);
                           
                           } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                           }
                        
                           System.out.print("2...");
                           try {
                           
                              Thread.sleep(1000);
                           
                           } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                           }
                        
                           System.out.print("3...");
                           try {
                           
                              Thread.sleep(1000);
                           
                           } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                           }
                           if (bullet == 1) {
                              System.out.println("BANG! You shot yourself!");
                              playerLife -= bullet2 ? 2 : 1; //bullet2 = 2 damage | bullet = 1 damage 
                              if (playerLife <= 1) {
                                 System.out.println(player + " has " + playerLife + " life left.");
                              } else {
                                 System.out.println(player + " has " + playerLife + " lives left.");
                              }
                              bullet2 = false; //upgraded bullet gone
                              System.out.println("");
                           
                              playerTurn = false; // Turn ends
                              roundContinues = false; // End the round
                              
                           } else {
                              System.out.println("Click! You're safe...");
                              System.out.println("You gain another turn!");
                              bullet--;
                              System.out.println("");
                              bullet2 = false; //upgraded bullet gone
                              
                                    // Player gets another turn, so do not switch turns
                           }
                        } else if (decision == 2) { // Shoot the enemy
                           System.out.println(player + " points the gun at the enemy...");
                           System.out.print("1...");
                           try {
                           
                              Thread.sleep(1000);
                           
                           } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                           }
                        
                           System.out.print("2...");
                           try {
                           
                              Thread.sleep(1000);
                           
                           } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                           }
                        
                           System.out.print("3...");
                           try {
                           
                              Thread.sleep(1000);
                           
                           } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                           }
                           if (bullet == 1) {
                              System.out.println("BANG! You shot the enemy!");
                              enemyLife -= bullet2 ? 2 : 1; //bullet2 = 2 damage | bullet = 1 damage 
                              if (playerLife <= 1) {
                                 System.out.println("The enemy has " + enemyLife + " life left.");
                              } else {
                                 System.out.println("The enemy has " + enemyLife + " lives left.");
                              }
                              playerTurn = false; // Turn ends
                              roundContinues = false; // End the round
                              bullet2 = false; //upgraded bullet gone
                              System.out.println("");
                           } else {
                              System.out.println("Click! The enemy is unharmed.");
                              bullet--;
                              playerTurn = false; // Turn ends
                              bullet2 = false; //upgraded bullet gone
                              System.out.println("");
                           }
                        } else if (decision == 3) { // Use trump cards
                           if (item_name.equals("Energy drink")) {
                              if (energyDrinkCooldown == 0) {
                                 if (playerLife < 3) {
                                    System.out.println( player + " used their special item.");
                                    playerLife++;
                                    System.out.println("[" + player + " has " + playerLife + " lives remaining.]");
                                    energyDrinkCooldown = 4;
                                    System.out.println(item_name + " is now on cooldown for " + energyDrinkCooldown + " turn(s).");
                                    System.out.println("");   
                                 
                                 } else if (playerLife == 3) {
                                    System.out.println( player + " tried to use their special item. However...");
                                    System.out.println(player + " is at full health.");
                                    System.out.println("[No effect]");
                                    energyDrinkCooldown = 4;
                                    System.out.println(item_name + " is now on cooldown for " + energyDrinkCooldown + " turn(s).");
                                    System.out.println("");
                                 
                                 }
                              } else {
                                 System.out.println( player + " tried to use their special item. However...");
                                 System.out.println(item_name + " is on cooldown! (" + energyDrinkCooldown + " more turn(s))");
                                 System.out.println("[Turn skipped]");
                                 System.out.println("");
                                 playerTurn = false; // Turn ends
                              
                              }
                           
                           } else if (item_name.equals("Cigarette")) {
                              if (cigaretteCooldown == 0) {
                                 System.out.println(player + " used their special item.");
                                 bullet2 = true; //activation of upgraded bullet 
                                 System.out.println("[The bullet has been upgraded to deal 2x damage!]");
                                 cigaretteCooldown = 5;
                                 System.out.println(item_name + " is now on cooldown for " + cigaretteCooldown + " turn(s).");
                                 System.out.println("");
                              } else {
                                 System.out.println( player + " tried to use their special item. However...");
                                 System.out.println(item_name + " is on cooldown! (" + cigaretteCooldown + " more turn(s))");
                                 System.out.println("[Turn skipped]");
                                 System.out.println("");
                                 playerTurn = false; // Turn ends
                              
                              }
                              
                           } else if (item_name.equals("Magnifying glass")) {
                              if (magnifyingGlassCooldown == 0) {
                                 System.out.println(player + " used their special item.");
                                 System.out.println("[The bullet will fire in " + bullet + " turn(s)]");
                                 magnifyingGlassCooldown = 4;
                                 System.out.println(item_name + " is now on cooldown for " + magnifyingGlassCooldown + " turn(s).");
                                 System.out.println("");
                              } else {
                                 System.out.println( player + " tried to use their special item. However...");
                                 System.out.println(item_name + " is on cooldown! (" + magnifyingGlassCooldown + " more turn(s))");
                                 System.out.println("[Turn skipped]");
                                 System.out.println("");
                                 playerTurn = false; // Turn ends
                              }
                           }
                              
                        
                                                      
                        } else {
                           System.out.println("[Invalid choice. Turn skipped.]");
                           System.out.println("");
                           playerTurn = false; // Turn ends
                        }
                     
                        // Decrease cooldowns after the player's turn
                        energyDrinkCooldown = Math.max(0, energyDrinkCooldown - 1);
                        cigaretteCooldown = Math.max(0, cigaretteCooldown - 1);
                        magnifyingGlassCooldown = Math.max(0, magnifyingGlassCooldown - 1);
                        
                     } else { // Enemy's turn
                        System.out.println("----------------------------------------------------");
                        System.out.println("");
                        System.out.println("Enemy's turn...");
                        try {
                           
                           Thread.sleep(1500);
                           
                        } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                        }
                     
                        int enemyChoice = r.nextInt(3) + 1; // Random enemy action (1 or 2)
                     
                        if (enemyChoice == 1) { // Shoot itself
                           System.out.println("The enemy points the gun at themselves...");
                           System.out.print("1...");
                           try {
                           
                              Thread.sleep(1000);
                           
                           } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                           }
                        
                           System.out.print("2...");
                           try {
                           
                              Thread.sleep(1000);
                           
                           } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                           }
                        
                           System.out.print("3...");
                           try {
                           
                              Thread.sleep(1000);
                           
                           } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                           }
                           if (bullet == 1) {
                              System.out.println("BANG! The enemy shot themselves!");
                              enemyLife -= bullet2 ? 2 : 1;
                              if (enemyLife <= 1) {
                                 System.out.println("The enemy has " + enemyLife + " life left.");
                              } else {
                                 System.out.println("The enemy has " + enemyLife + " lives left.");
                              }
                              playerTurn = true; // Turn switches back to the player
                              roundContinues = false; // End the round
                              bullet2 = false; //upgraded bullet gone
                           
                           } else {
                              System.out.println("Click! The enemy is safe...");
                              System.out.println("The enemy gains another turn!");
                              bullet--;
                              bullet2 = false; //upgraded bullet gone
                                    // Enemy gets another turn, so do not switch turns
                           }
                           System.out.println("");
                        } else if (enemyChoice == 2) { // Shoot the player
                           System.out.println("The enemy points the gun at " + player + "...");
                           System.out.print("1...");
                           try {
                           
                              Thread.sleep(1000);
                           
                           } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                           }
                        
                           System.out.print("2...");
                           try {
                           
                              Thread.sleep(1000);
                           
                           } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                           }
                        
                           System.out.print("3...");
                           try {
                           
                              Thread.sleep(1000);
                           
                           } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                           }
                           if (bullet == 1) {
                              System.out.println("BANG! The enemy shot you!");
                              playerLife -= bullet2 ? 2 : 1;
                              if (playerLife <= 1) {
                                 System.out.println(player + " has " + playerLife + " life left.");
                              } else {
                                 System.out.println(player + " has " + playerLife + " lives left.");
                              }
                              playerTurn = true; // Turn switches back to the player
                              roundContinues = false; // End the round
                              bullet2 = false; //upgraded bullet gone
                              System.out.println("");
                           } else {
                              System.out.println("Click! You're unharmed...");
                              playerTurn = true; // Turn switches back to the player
                              bullet--;
                              bullet2 = false; //upgraded bullet gone
                              System.out.println("");
                           }
                        } else { //special item for enemy
                           if (item_name2.equals("Energy drink")) {
                              if (energyDrinkCooldown2 == 0) {
                                 if (enemyLife < 3) {
                                    System.out.println("The enemy used their special item.");
                                    enemyLife++;
                                    System.out.println("[The enemy has " + enemyLife + " lives remaining.]");
                                    energyDrinkCooldown2 = 4;
                                    System.out.println(item_name2 + " is now on cooldown for " + energyDrinkCooldown2 + " turn(s).");
                                    System.out.println("");
                                 
                                 } else if (enemyLife == 3) {
                                    System.out.println("The enemy tried to use their special item. However...");
                                    System.out.println("The enemy is at full health.");
                                    System.out.println("[No effect]");
                                    energyDrinkCooldown2 = 4;
                                    System.out.println(item_name2 + " is now on cooldown for " + energyDrinkCooldown2 + " turn(s).");
                                    System.out.println("");
                                 }
                              } else {
                                 System.out.println("The enemy tried to use their special item. However...");
                                 System.out.println(item_name2 + " is on cooldown! (" + energyDrinkCooldown2 + " more turn(s))");
                                 System.out.println("[Turn skipped]");
                                 System.out.println("");
                                 playerTurn = true; // Turn switches back to the player
                              }
                           
                           } else if (item_name2.equals("Cigarette")) {
                              if (cigaretteCooldown2 == 0) {
                                 System.out.println("The enemy used their special item.");
                                 bullet2 = true;
                                 System.out.println("[The bullet has been upgraded to deal 2x damage!]");
                                 cigaretteCooldown2 = 5;
                                 System.out.println(item_name2 + " is now on cooldown for " + cigaretteCooldown2 + " turn(s).");
                                 System.out.println("");
                              } else {
                                 System.out.println("The enemy tried to use their special item. However...");
                                 System.out.println(item_name2 + " is on cooldown! (" + cigaretteCooldown2 + " more turn(s))");
                                 System.out.println("[Turn skipped]");
                                 System.out.println("");
                                 playerTurn = true; // Turn switches back to the player
                              }
                              
                           } else if (item_name2.equals("Magnifying glass")) {
                              if (magnifyingGlassCooldown2 == 0) {
                                 System.out.println("The enemy used their special item.");
                                 System.out.println("[The bullet's position is revealed to the enemy.]");
                                 magnifyingGlassCooldown2 = 4;
                                 System.out.println(item_name2 + " is now on cooldown (" + magnifyingGlassCooldown2 + " turn(s)).");
                                 System.out.println("");
                              } else {
                                 System.out.println("The enemy tried to use their special item. However...");
                                 System.out.println(item_name2 + " is on cooldown! (" + magnifyingGlassCooldown2 + " more turn(s))");
                                 System.out.println("[Turn skipped]");
                                 System.out.println("");
                                 playerTurn = true; // Turn switches back to the player
                              }
                           }
                              // Decrease cooldowns after the enemy's turn
                           energyDrinkCooldown2 = Math.max(0, energyDrinkCooldown2 - 1);
                           cigaretteCooldown2 = Math.max(0, cigaretteCooldown2 - 1);
                           magnifyingGlassCooldown2 = Math.max(0, magnifyingGlassCooldown2 - 1);
                        }
                     }
                  }
                  
                  // Proceed to the next round
                  round++;
               }
            
                // Game result
               if (playerLife > 0) {
                  System.out.println(player + " wins!");
                  System.out.println("");
                  System.out.println("----------------------------------------------------");
                  System.out.println("                 CONGRATULATIONS!");
                  System.out.println("----------------------------------------------------");
                     
               } else {
                  System.out.println("The enemy wins!");
                  System.out.println("");
                  System.out.println("----------------------------------------------------");
                  System.out.println("                   GAME OVER!");
                  System.out.println("----------------------------------------------------");
               }
            
               do {         
               
                  System.out.println("\nDo you want to play again? (yes/no)");
                  System.out.println("");
                  System.out.print(player + ": ");
                  play2 = s1.nextLine();
                  
               
                  if (play2.equalsIgnoreCase("no")) {
                     System.out.println("");
                     System.out.println("Thank you for playing, " + player + "!");
                     System.out.println("[Player Exited]");
                     break;
                  } else {
                     System.out.println("");
                     System.out.println("[Invalid answer. Please enter yes or no.]");
                  }
               } while (!play2.equalsIgnoreCase("yes") && !play2.equalsIgnoreCase("no"));
            
            } while (play2.equalsIgnoreCase("yes"));
            
         
         } else if (ans.equalsIgnoreCase("no")) {
            System.out.println("");
            System.out.println("Thank you for playing, " + player + "!");
            
            System.out.println("[Player Exited]");
            break;
            
         } else {
            System.out.println("");
            System.out.println("[Invalid answer. Please enter yes or no.]");
         }   
      } while (!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no"));
   
      s.close();
      s1.close();
   }
}

