<p id="points"></p>

<p>
	<span class='minus'>-</span>
	<form:input value="0" min="0" class="stat" type="number" path="strength" readonly/>
	<span class='plus'>+</span>
</p>
<p>
	<span class='minus'>-</span>
	<form:input value="0" min="0" class="stat" type="number" path="constitution" readonly/>
	<span class='plus'>+</span>
</p>
<p>
	<span class='minus'>-</span>
	<form:input value="0" min="0" class="stat" type="number" path="dexterity" readonly/>
	<span class='plus'>+</span>
</p>
<p>
	<span class='minus'>-</span>
	<form:input value="0" min="0" class="stat" type="number" path="willpower" readonly/>
	<span class='plus'>+</span>
</p>
<p>
	<span class='minus'>-</span>
	<form:input value="0" min="0" class="stat" type="number" path="intelligence" readonly/>
	<span class='plus'>+</span>
</p>
<p>
	<span class='minus'>-</span>
	<form:input value="0" min="0" class="stat" type="number" path="charisma" readonly/>
	<span class='plus'>+</span>
</p>

<p>
	<form:input value="10" min="10" id="health" type="number" path="health" readonly/>
	<form:input value="10" min="10" id="mana" type="number" path="mana" readonly/>
</p>

<script>
	
		var level = document.getElementById('level').value
		var points = level * 10;
		document.getElementById("points").innerHTML = points;
		$('.plus').click(function(){
			if(points > 0){
				points -=1;
				$(this).parent('.stat').value += 1;
			}
		});
		$('.minus').click(function(){
			if($(this).parent('.stat').value > 0){
				points +=1;
				$(this).parent('.stat').value -= 1;
			}
		});
</script>