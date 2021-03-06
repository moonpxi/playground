class CombatScribe

  def initialize
    @turn_number = 1
  end
  
  def begin_turn
    puts_header "Turn #@turn_number"
    @turn_number += 1
  end 

  def register_attack(attacker, defender, type, damage)
    puts DescriptionsGrammar.attack_move(:attacker => attacker, :defender => defender, :attack => type, :damage => damage)
  end

  def health_status_of(fighter1, fighter2)
    status_print = lambda { |f| "#{f.name} has #{f.health} hit points." }
    puts status_print.call(fighter1) + ' ' + status_print.call(fighter2)
  end

  def finish_combat_between(fighter1, fighter2)
    puts_header "THE END"
    puts "#{fighter1.name} is dead" unless fighter1.alive?
    puts "#{fighter2.name} is dead" unless fighter2.alive? 
  end

 private

  def puts_header(text)
    puts "\n--- #{text} ---"
  end
end