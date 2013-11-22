GUI Example Layout
==================

This is just an example. You can do whatever you want, but I figured I'd give you an example layout just to get you on the right track.  
(I don't know if your one of those people that needs a template to work off of, or if you like complete freedom)  

```
+-----------------------+		+-----------------------+				   +-----------------------+
|	   [Logo here]		|		| 	   Enter DFU...		|				   | /--------\|\  ^ --- ^ |
|  __			________|		|	1. Hold Powe	    |				   | | [] ~~~ ||/ / \ | / \|
| |  | Plug in |It wont | ----\ |   2. Hold Home+Power	|				   | | [] ~~~ |            |
| |__| Device  |Boot up	| ----/ |   3. Hold Home		|				   | \--------/   {DONE}   |
+-----------------------+		+-----------------------+				   +-----------------------+
			|							   |										   ^				+-----------------------+
			|							   |										   |				| /--------\  ^ |> |> \-|
			L______________________________|										   |	  /-------> | | [] ~~~ | / \|  |  _\|
						   |														   |	  |			| | [] ~~~ |            |
						   |							 +-----------------------+     |	  |			| \--------/   {DONE}   |
						   |							 | [] Backup Data        | ----/      |			+-----------------------+
						   V					/------> | [] Backup Apps        | -----------/
				+-----------------------+       |		 | [] Backup Packages    | -----------\			+-----------------------+
				|  ----					|       |		 | [] Backup Custom Path | ----\      |			| /--------\   ^ |> --- |
				| | ~~ | ---> Backup	| ------/		 +-----------------------+     |      \-------> | | [] ~~~ |  / \|   |  |
				| |    | <--- Restore	| ------\		 +-----------------------+     |				| | [] ~~~ |            |
				| |_()_|				|       |		 |      (        )		 |						| \--------/   {DONE}   |
				+-----------------------+       |		 |     (  iCloud  )		 |						+-----------------------+
												\------> |      (________)		 |
														 |     Manual Backup	 |
														 +-----------------------+
```
