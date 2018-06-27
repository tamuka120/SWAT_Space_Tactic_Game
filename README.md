# SWAT_Space_Tactic_Game

“Space Wars and Tactics” (SWAT) is a strategy game. The current prototype provides a very simplified version of the game for one player. In the future, this game will allow a player/s to play against each other and will have a more complex set of fights and forces, as well as introducing random elements.

Here is the briefing provided to a player: In a galaxy far away, you are an Admiral of the Allied Space Fleet(ASF)  fighting against the Empire Collective which has a number of different types of enemies and  uses different types of fight tactics. To win, you must assemble your forces into a fighting fleet which can meet (and hopefully win) these fights with your enemies. The game provides a collection of forces which you can activate.  Initially, all ASF forces are inactive (“in dock”) and not part of your fighting fleet.

You have at your disposal 1000 bit coins in your war chest. As the admiral, you must  assemble your fighting fleet by selecting (activating) some of the forces in the Allied Space Fleet. However, activating a force will cost you an activation fee. You will then be expected to undertake some fights. Winning a fight will bring you gains and increase your war chest. Losing a fight will cost you and decrease your war chest. In addition, if a force is defeated in a fight, it is destroyed and cannot be used again.

Your enemies offer different types of fights. Each fight has a unique number (allocated sequentially from1 by the system), a fight type, the enemy, enemy strength, gains and losses. For this prototype, the player selects a fight by its number (in later versions the fight will be chosen using random numbers). The system will then find the first appropriate force in the fighting fleet to engage in the fight and compares battle strengths of the force and the enemy. The results of a fight will be one of the following:
1.	“Fight won by the force – add fight gains to the resources
2.	“Fight lost as no suitable force available” – deduct the fight losses from resources 
3.	“Fight lost by force on battle strength ” - deduct fight losses from resources, decommission force
Fights may be undertaken more than once.

Each force has a unique fleet reference, a full name, an activation fee, and battle strength. There are three types of forces : Wings, Starships, WarBirds and each has additional features. WarBirds have an activation fee of 300 bit coins, but if they have a cloaking device their fee is 400 bit coins. Starships set their activation fee based on the number of laser canons (30 bit coins for each laser cannon) and Wings have an activation fee of 200 bit coins. The battle strength of a Wing is 20 for each of its strikers. The battle strength of a Starship is 5 for each photon torpedo and 10 for each laser cannon. WarBird can have different war strengths (See Appendix A)

In order to save resources and lives, the Chiefs of Staff have decided that Wings should not be used in battles, Starships should not be sent on ambushes and WarBirds should not be used in skirmishes. In addition, WarBirds can only be used for ambushes, if they have a cloaking device. 

During the game, a force can be in one of the following states:
•	docked – in the Allied Space Fleet, but not yet activated as part of your fleet
•	active – activated as part of the fleet and available for fights
•	destroyed – defeated and cannot be used further in fights

After losing a fight, your war chest may be <0. You cannot activate more forces. However, you can continue to undertake fights with your forces in the hope of winning some more money (even if your war chest goes further into debt). You may also make money by recalling forces back to the dock, when half of their activation cost is added back to your war chest.. However, if your war chest has no money or is in debt, and you have no forces to recall, then you have lost the game and a suitable message should be output. Forces may be activated or recalled at any point in the game. 
