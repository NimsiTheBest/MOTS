package example.content;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.TextureRegion;
import arc.math.Interp;
import arc.math.Mathf;
import arc.util.Time;
import mindustry.ai.types.BuilderAI;
import mindustry.ai.types.CargoAI;
import mindustry.ai.types.GroundAI;
import mindustry.content.Fx;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.ParticleEffect;
import mindustry.entities.part.HaloPart;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootHelix;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.*;
import mindustry.graphics.Layer;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class BioUnits {
    public static UnitType

            //air offense
            //darken,

            //ground defense
            watt,
    ;

		watt = new TankUnitType("watt") {{
		    float unitRange = 32 * tilesize;
		    health = 950;
		    armor = 25;
		    hitSize = 13;
		    terrainSpeedMultiplier = 1f;
		    terrainDragMultiplier = 1.3f;
		    speed = 5.5f;
		    accel = 0.04f;
		    rotateSpeed = 1.5f;
		    ammoType = new ItemAmmoType(Items.graphite);
		
		    range = unitRange;
		
		    immunities = ObjectSet.with(
		        StatusEffects.disarmed,
		        UAWStatusEffects.EMP,
		        StatusEffects.freezing
		    );
		
		    treadFrames = 6;
		    treadPullOffset = 4;
		    treadRects = new Rect[]{
		        // 0
		        new Rect(8 - 96 / 2f, 33 - 144 / 2f, 16, 66)
		    };
		    weapons.addAll(
		        // Main Gun
		        new Weapon(name + "-turret") {{
		            layerOffset = 0.1f;
		            mirror = false;
		
		            x = 0f;
		            y = 0f;
		
		            rotate = true;
		            rotateSpeed = 3;
		            reload = 1.5f * tick;
		            recoil = 0;
		            shootY = 68f * px;
		            shake = 6f;
		
		            soundPitchMin = 1.2f;
		            soundPitchMax = soundPitchMin + 0.4f;
		            shootSound = Sfx.wp_k_gunShoot_6;
		
		            ejectEffect = UAWFx.casing2Long;
		
		            bullet = new TrailBulletType(5f, 140) {{
		                splashDamage = damage;
		                splashDamageRadius = 3 * tilesize;
		                frontColor = Pal.missileYellow;
		                trailColor = backColor = Pal.missileYellowBack;
		                height = 25f;
		                width = 8f;
		                lifetime = unitRange / speed;
		                knockback = 4f;
		                despawnHit = true;
		                shootEffect = new MultiEffect(
		                    UAWFx.railShoot(35f, backColor),
		                    Fx.shootPyraFlame,
		                    Fx.shootSmallSmoke
		                );
		                hitEffect = new MultiEffect(
		                    Fx.blastExplosion,
		                    Fx.fireHit,
		                    Fx.blastsmoke
		                );
		                trailInterval = 1.6f;
		                trailChance = 0.3f;
		                trailEffect = new MultiEffect(
		                    Fx.hitBulletColor,
		                    Fx.hitFlameSmall
		                );
		                hitSound = Sounds.explosion;
		                fragBullets = 8;
		                collidesAir = false;
		                fragBullet = fragGlassFrag;
		                status = StatusEffects.burning;
		            }};
		        }}
		    );
		}};


